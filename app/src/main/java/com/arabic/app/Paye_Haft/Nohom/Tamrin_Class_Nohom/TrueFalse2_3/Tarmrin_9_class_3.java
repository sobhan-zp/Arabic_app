package com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.TrueFalse2_3;

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
import com.arabic.app.R;
import com.arabic.app.model.model_9_class.Model_TrueFalse2_9_class_3;
import com.arabic.app.model.model_9_class.Model_TrueFalse_9_class_1;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class Tarmrin_9_class_3 extends AppCompatActivity {

    private String[] quiz =

            {

                    "أنتُنَّ بَدَأْتُنَّ      شما....", //1
                    "هوَ ما قَرَأَ      او.....", //2
                    "أنتُمْ ما وَصَلْتُم    شما....",//3
                    "أنتُما سَمِعْتُما    شما.....",//4
                    "أنتُما ما قَطَعْتُما    شما.....",//5
                    "أنتُنَّ سَمَحْتُنَّ    شما....."//6



            };


    private String[] t =

            {

                   "شروع کردید",
                   "نمی خواند",
                   "نرسیدید",
                   "شنیدید",
                   "نمی برید",
                   "اجازه می دهید"



            };


    private String[] f =

            {

                    "شروع میکنید",
                    "نخواند",
                    "نخواهدرسید",
                    "نشنیدید",
                    "نبریدید",
                    "اجازه دادید"


            };





    public static int[] ansever =

            {

                    1,
                    2,
                    1,
                    1,
                    2,
                    2





            };


    private List<Model_TrueFalse2_9_class_3> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_class_9_3;
    private RecyclerAdaper_Tamrin_9_class_3 adapter_user;

    Button Btn_next3_Tamrin_class_9;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_class_3);
        Fabric.with(this, new Crashlytics());
        save=new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در کلاس");

        Log.e("TAg--------", "Tarmrin_9_class_3");


        Btn_next3_Tamrin_class_9 = (Button)findViewById(R.id.Btn_next3_Tamrin_class_9);
        Btn_next3_Tamrin_class_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AppController.CLOSE_ACTIVITY = true;
                finish();

                /*Intent i = new Intent(Tarmrin_9_class_3.this , Tarmrin_9_class_2.class);
                startActivity(i);*/
            }
        });


        rv_Tamrin_class_9_3 = (RecyclerView) findViewById(R.id.rv_Tamrin_class_9_3);
        adapter_user = new RecyclerAdaper_Tamrin_9_class_3(Tarmrin_9_class_3.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_class_3.this);
        rv_Tamrin_class_9_3.setLayoutManager(mLayoutManager);
        rv_Tamrin_class_9_3.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_class_9_3.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_TrueFalse2_9_class_3 soal = new Model_TrueFalse2_9_class_3(i, quiz[i], t[i] ,f[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }




}
