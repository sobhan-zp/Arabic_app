package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.moratab_sazi_2.RecyclerAdaper_Tamrin_8_class_2;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Tarjome_sahih_4.Tarmrin_8_home_4;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_3.Azmoon_9_3;
import com.arabic.app.R;
import com.arabic.app.model.model_8_class.Model_Moratab_Sazi_8_class_2;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_2;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_2 extends AppCompatActivity {

    //ListView lvTitleMt;
    String[] quiz_motazad;
    private Button Btn_next2_azmoon_9_2;
    SavePref save;


    public static String[] quiz =

            {

                    "لیس بعیدا",
                    "فیه أشجارٌ کثیرة",
                    "والد الاُمِّ",
                    "وسیلة للذهاب بالسرعة",
                    "لیس قبیح"



            };

    public static int[] javab = {

            2,
            6,
            4,
            3,
            5
    };



    private List<Model_Azmoon_9_2> itemList_moratab_sazi = new ArrayList<>();
    private RecyclerView rv_azmoon_9_2;
    private RecyclerAdaper_Azmoon_9_2 adapter_moratab_sazi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_2);

        save = new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        // get the string array from string.xml file
       // quiz_motazad = getResources().getStringArray(R.array.quiz_motazad);


        Btn_next2_azmoon_9_2 = (Button)findViewById(R.id.Btn_next2_azmoon_9_2);
        Btn_next2_azmoon_9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(Tamrin_8_class_2.this, "", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Azmoon_9_2.this , Azmoon_9_3.class);
                startActivity(i);
            }
        });

        rv_azmoon_9_2 = (RecyclerView) findViewById(R.id.rv_azmoon_9_2);
        adapter_moratab_sazi = new RecyclerAdaper_Azmoon_9_2(Azmoon_9_2.this, itemList_moratab_sazi);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_2.this);
        rv_azmoon_9_2.setLayoutManager(mLayoutManager);
        rv_azmoon_9_2.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_2.setAdapter(adapter_moratab_sazi);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_2 soal = new Model_Azmoon_9_2(i, quiz[i],"الجدّةِ" , "القریبِ", "السیارة","الجدّ" ,"الجمیل ","البستان",  javab[i]);
            itemList_moratab_sazi.add(soal);
        }
        adapter_moratab_sazi.notifyDataSetChanged();


    }


    @Override
    protected void onResume() {
        if(AppController.CLOSE_ACTIVITY){
            finish();
        }
        super.onResume();
    }

    @Override
    public void onBackPressed() {

    }


}