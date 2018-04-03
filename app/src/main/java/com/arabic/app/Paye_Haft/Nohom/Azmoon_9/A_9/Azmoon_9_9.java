package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_9;

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
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_6.RecyclerAdaper_Azmoon_9_6;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_7.Azmoon_9_7;
import com.arabic.app.R;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_6;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_9;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_9 extends AppCompatActivity {

    private String[] quiz =

            {

                  "المرأتانِ .... جنب المکتبة ",
                  "أنتُنَّ .... دروسکنَّ",
                  "یا معین و یاآناهیتا! أ.... الماء؟",
                  "الاُستاذُِ .... لَکَ بِالکَلامِ",
                  "هَلْ سُمَیَّةُ .... واجِباتِها "





            };


    private String[] char1 =

            {

                    "جَلَسَت",
                    "قرأتما",
                    "شربتما",
                    "سَمَحَ ",
                    "کَتَبَتُ"






            };


    private String[] char2 =

            {

                    " جَلَسَتا",
                    " قرأتما",
                    " شربتَ",
                    " سَمَحَا",
                    " کَتَبَتْ"

            };



    private String[] char3 =

            {

                    "جَلسنَ",
                    "قرأتنَّ   ",
                    "شربت",
                    "سمحوا",
                    "کَتَبَتِ"


            };


    private String[] char4 =

            {

                    "جلسنا ",
                    "قرأتم",
                    "شربتما  ",
                    "سمحَتْ",
                    "کَتَبَتَ"


            };



    public static int[] ansever =

            {

                    2,
                    3,
                    4,
                    1,
                    2



            };


    private List<Model_Azmoon_9_9> itemList_user = new ArrayList<>();
    private RecyclerView rv_azmoon_9_9;
    private RecyclerAdaper_Azmoon_9_9 adapter_user;

    Button Btn_next9_azmoon_9_9;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_9);

        save=new SavePref(this);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next9_azmoon_9_9 = (Button)findViewById(R.id.Btn_next9_azmoon_9_9);
        Btn_next9_azmoon_9_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Intent i = new Intent(Azmoon_9_9.this , Azmoon_9_7.class);
                startActivity(i);*/

                AppController.CLOSE_ACTIVITY = true;
                finish();
            }
        });


        rv_azmoon_9_9 = (RecyclerView) findViewById(R.id.rv_azmoon_9_9);
        adapter_user = new RecyclerAdaper_Azmoon_9_9(Azmoon_9_9.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_9.this);
        rv_azmoon_9_9.setLayoutManager(mLayoutManager);
        rv_azmoon_9_9.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_9.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_9 soal = new Model_Azmoon_9_9(i, quiz[i], char1[i] ,char2[i],char3[i],char4[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }



    @Override
    public void onBackPressed() {

    }
}
