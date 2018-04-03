package com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.TrueFalse2_4;

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
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2.Tarmrin_9_class_2;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.TrueFals_3.RecyclerAdaper_Tamrin_9_home_3;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.TrueFals_3.Tarmrin_9_home_3;
import com.arabic.app.R;
import com.arabic.app.model.model_9_home.Model_TrueFalse2_9_home_4;
import com.arabic.app.model.model_9_home.Model_TrueFalse_9_home_3;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class Tarmrin_9_home_4 extends AppCompatActivity {

    private String[] quiz =

            {

                    "یا بِنتانِ ! هَل................ تلک  الکتابَ؟", //1
                    "أنتِ ................... بابَ الغُرفة ",
                    "............. جَلَستُنَّ خَلفَ  هذِهِ الشَّجرَةِ",
                    ".............. شَرِبتُم الماءَ"


            };


    private String[] t =

            {

                   "قَرَأتُما",
                   "فَتَحتِ",
                   "أنتُم",
                   "نَحنُ "

            };


    private String[] f =

            {

                    "َرَأتِ",
                    "فَتَحَتْ",
                    "أنتُنَّ",
                    "أنتُم "

            };





    public static int[] ansever =

            {

                    1,
                    1,
                    2,
                    2

            };


    private List<Model_TrueFalse2_9_home_4> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_9_4;
    private RecyclerAdaper_Tamrin_9_home_4 adapter_user;

    Button Btn_next4_Tamrin_home_9;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_home_4);
        Fabric.with(this, new Crashlytics());
        save=new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین درخانه");

        Log.e("TAg--------", "Tarmrin_9_home_3");


        Btn_next4_Tamrin_home_9 = (Button)findViewById(R.id.Btn_next4_Tamrin_home_9);
        Btn_next4_Tamrin_home_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               AppController.CLOSE_ACTIVITY = true;
                finish();

               /* Intent i = new Intent(Tarmrin_9_home_4.this , Tarmrin_9_class_2.class);
                startActivity(i);*/
            }
        });


        rv_Tamrin_home_9_4 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_9_4);
        adapter_user = new RecyclerAdaper_Tamrin_9_home_4(Tarmrin_9_home_4.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_home_4.this);
        rv_Tamrin_home_9_4.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_9_4.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_9_4.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_TrueFalse2_9_home_4 soal = new Model_TrueFalse2_9_home_4(i, quiz[i], t[i] ,f[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }


}
