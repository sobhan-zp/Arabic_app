package com.arabic.app.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.CustomRequest;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.crashlytics.android.Crashlytics;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class DoneActivity extends AppCompatActivity {

    Button btnTryAgain;
    TextView txtResultScore, txtResultQuestion, txtTitleDone;
    ProgressBar progressBarResult;
    SavePref save;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        Fabric.with(this, new Crashlytics());

        DbHelper db = new DbHelper(this);

        dialog = new ProgressDialog(this);
        save = new SavePref(this);

        txtTitleDone = (TextView) findViewById(R.id.txtTitleDone);
        txtTitleDone = (TextView) findViewById(R.id.txtTitleDone);
        txtResultScore = (TextView) findViewById(R.id.txtTotalScore);
        txtResultQuestion = (TextView) findViewById(R.id.txtTotalQuestion);
        progressBarResult = (ProgressBar) findViewById(R.id.doneProgressBar);
        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);*/
                finish();


            }
        });


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            int score = 0;
            int totalQuestion = 0;
            int correctAnswer = 0;

            Log.e("TAH____________", ""+score);

            if(extra.getInt("MODE") == 1){
                txtTitleDone.setText("نتیجه آزمون شما برای استاد ارسال شده است");
                save.save(AppController.SAVE_AZMON_9, 1);
                txtResultQuestion.setVisibility(View.GONE);

                sendAzmonResult(extra.getString("SCORE"), "9", "7");
            }else {
                score = extra.getInt("SCORE");
                totalQuestion = extra.getInt("TOTAL");
                correctAnswer = extra.getInt("CORRECT");
            }

            //Update 2.0
            int playCount = 0;
            if(totalQuestion == 30) // EASY MODE
            {
                playCount = db.getPlayCount(0);
                playCount++;
                db.updatePlayCount(0,playCount); // Set PlayCount ++
            }
            else if(totalQuestion == 50) // MEDIUM MODE
            {
                playCount = db.getPlayCount(1);
                playCount++;
                db.updatePlayCount(1,playCount); // Set PlayCount ++
            }
            else if(totalQuestion == 100) // HARD MODE
            {
                playCount = db.getPlayCount(2);
                playCount++;
                db.updatePlayCount(2,playCount); // Set PlayCount ++
            }
            else if(totalQuestion == 200) // HARDEST MODE
            {
                playCount = db.getPlayCount(3);
                playCount++;
                db.updatePlayCount(3,playCount); // Set PlayCount ++
            }

            double subtract = ((5.0/(float)score)*100)*(playCount-1); //-1 because we playCount++ before we calculate result
            double finalScore = score - subtract;

            txtResultScore.setText(String.format("نمره : %.1f (-%d)%%", finalScore,5*(playCount-1)));
            txtResultQuestion.setText(String.format("جواب درست : %d/%d", correctAnswer, totalQuestion));

            progressBarResult.setMax(totalQuestion);
            progressBarResult.setProgress(correctAnswer);


            if(extra.getInt("MODE") == 1){
                txtResultScore.setText("نمره :"+extra.getString("SCORE"));
            }


            //save score
            //db.insertScore(finalScore);
        }
    }



    private void sendAzmonResult(String score, String azmon, String id_class) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("id_user", save.load(AppController.SAVE_USER_ID, "-1"));
        params.put("score", score);
        params.put("azmon", azmon);
        params.put("id_class", id_class);

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, AppController.URL_AZMON_RESULT, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject resp = response;
                //Log.d("TAG--------OK", resp.toString());

                try {
                    if(resp.getString("status").equals("200")){

                        Toast.makeText(DoneActivity.this, "نتایج ارسال شد", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(DoneActivity.this, "بعدا سعی کنید", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("TAG--------Error", "Error: " + error.getMessage());

                Toast.makeText(DoneActivity.this, "لطفا در زمان دیگری اقدام کنید", Toast.LENGTH_SHORT).show();

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        jsonObjReq.setShouldCache(false);
        //myRequestQueue.getCache().clear();
        AppController.getInstance().addToRequestQueue(jsonObjReq,"SEND_AZMON_9");

    }
}
