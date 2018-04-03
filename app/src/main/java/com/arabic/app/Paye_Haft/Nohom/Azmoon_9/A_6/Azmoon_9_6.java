package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_5.Azmoon_9_5;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_7.Azmoon_9_7;
import com.arabic.app.R;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_6;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_6 extends AppCompatActivity {

    private String[] quiz =

            {

                    "... هو خیر الناس - أنفعُ الناس", //1
                    "....أنتم؟ - نحن من الإیران", //2
                    "... ذهبتَ یا علیّ ؟ - إلی البیت", //3
                    "یا ولدی!.... رجعتَ إلی الإیرانِ؟ - بالسّیّارة", //4






            };


    private String[] char1 =

            {

                    "",//1
                    "",//2
                    "",//3
                    ""//4



            };


    private String[] char2 =

            {

                    "ما",
                    "أینَ",//2
                    "أینَ",
                    "لماذا"


            };



    private String[] char3 =

            {

                    "مَن",
                    "مِن أینَ",//2
                    "کیف",
                    "کیفَ"


            };



    public static int[] ansever =

            {

                    2,
                    2,
                    1,
                    2



            };


    private List<Model_Azmoon_9_6> itemList_user = new ArrayList<>();
    private RecyclerView rv_azmoon_9_6;
    private RecyclerAdaper_Azmoon_9_6 adapter_user;

    Button Btn_next6_azmoon_9_6;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_6);

        save=new SavePref(this);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next6_azmoon_9_6 = (Button)findViewById(R.id.Btn_next6_azmoon_9_6);
        Btn_next6_azmoon_9_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_4.this, "next", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Azmoon_9_6.this , Azmoon_9_7.class);
                startActivity(i);
            }
        });


        rv_azmoon_9_6 = (RecyclerView) findViewById(R.id.rv_azmoon_9_6);
        adapter_user = new RecyclerAdaper_Azmoon_9_6(Azmoon_9_6.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_6.this);
        rv_azmoon_9_6.setLayoutManager(mLayoutManager);
        rv_azmoon_9_6.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_6.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_6 soal = new Model_Azmoon_9_6(i, quiz[i] ,char2[i],char3[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }


    @Override
    protected void onResume() {
        if(AppController.CLOSE_ACTIVITY){
            finish();
        }
        super.onResume();
    }

}
