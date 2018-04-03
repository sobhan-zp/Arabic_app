package com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.TrueFals_3;

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
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.TrueFalse_1.RecyclerAdaper_Tamrin_9_class_1;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2.Tarmrin_9_class_2;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.TrueFalse2_4.Tarmrin_9_home_4;
import com.arabic.app.R;
import com.arabic.app.model.model_9_class.Model_TrueFalse_9_class_1;
import com.arabic.app.model.model_9_home.Model_TrueFalse_9_home_3;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class Tarmrin_9_home_3 extends AppCompatActivity {

    private String[] quiz =

            {

                    "ایّتُها البَنات  ! لِماذا سَألتُنّ  هذا السَؤالَ؟", //1
                    "رأیتُ زوجةَ علیٍّ فی المکتبة"


            };


    private String[] t =

            {

                   "ای دخترها  ! چرا این سؤال را پرسیدید",
                   "همسرش علی را در کتابخانه  دید"

            };


    private String[] f =

            {

                    "ای دختر! آیا این سؤال را پرسیدید؟",
                    "همسر علی را در کتابخانه  دیدم"

            };





    public static int[] ansever =

            {

                    1,
                    2


            };


    private List<Model_TrueFalse_9_home_3> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_9_3;
    private RecyclerAdaper_Tamrin_9_home_3 adapter_user;

    Button Btn_next3_Tamrin_home_9;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_home_3);
        Fabric.with(this, new Crashlytics());
        save=new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین درخانه");

        Log.e("TAg--------", "Tarmrin_9_home_3");


        Btn_next3_Tamrin_home_9 = (Button)findViewById(R.id.Btn_next3_Tamrin_home_9);
        Btn_next3_Tamrin_home_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               /* AppController.CLOSE_ACTIVITY = true;
                finish();*/

                Intent i = new Intent(Tarmrin_9_home_3.this , Tarmrin_9_home_4.class);
                startActivity(i);
            }
        });


        rv_Tamrin_home_9_3 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_9_3);
        adapter_user = new RecyclerAdaper_Tamrin_9_home_3(Tarmrin_9_home_3.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_home_3.this);
        rv_Tamrin_home_9_3.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_9_3.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_9_3.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_TrueFalse_9_home_3 soal = new Model_TrueFalse_9_home_3(i, quiz[i], t[i] ,f[i] , ansever[i]);
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
