package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.moratab_sazi_2;


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
import android.widget.Toast;

import com.arabic.app.Activity.DoneActivity;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.TainSath.Jaye_khali.Tamrin_7_Jaye_khali;
import com.arabic.app.model.model_8_class.Model_Moratab_Sazi_8_class_2;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_8_class_2 extends AppCompatActivity {

    //ListView lvTitleMt;
    String[] quiz_motazad;
    private Button Btn_next2_Tamrin_class_8;
    SavePref save;


    public static String[] quiz =

            {

                    "الْفُسْتانَُ",
                    "ألْعِلْمُ",
                    "الدُّنیا",
                    "الصَّلاةُ",
                    "ألنِّسْيانَُ",
                    "السُّؤالُ"


            };

    public static int[] javab = {

            4,
            5,
            6,
            1,
            3,
            2
    };



    private List<Model_Moratab_Sazi_8_class_2> itemList_moratab_sazi = new ArrayList<>();
    private RecyclerView rv__Tamrin_class_8_2;
    private RecyclerAdaper_Tamrin_8_class_2 adapter_moratab_sazi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tamrin_8_class_2);

        save = new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در کلاس");

        // get the string array from string.xml file
       // quiz_motazad = getResources().getStringArray(R.array.quiz_motazad);


        Btn_next2_Tamrin_class_8 = (Button)findViewById(R.id.Btn_next2_Tamrin_class_8);
        Btn_next2_Tamrin_class_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(Tamrin_8_class_2.this, "", Toast.LENGTH_SHORT).show();

                AppController.CLOSE_ACTIVITY = true;
                finish();
            }
        });

        rv__Tamrin_class_8_2 = (RecyclerView) findViewById(R.id.rv__Tamrin_class_8_2);
        adapter_moratab_sazi = new RecyclerAdaper_Tamrin_8_class_2(Tamrin_8_class_2.this, itemList_moratab_sazi);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_8_class_2.this);
        rv__Tamrin_class_8_2.setLayoutManager(mLayoutManager);
        rv__Tamrin_class_8_2.setItemAnimator(new DefaultItemAnimator());
        rv__Tamrin_class_8_2.setAdapter(adapter_moratab_sazi);


        for (int i = 0; i < quiz.length; i++) {
            Model_Moratab_Sazi_8_class_2 soal = new Model_Moratab_Sazi_8_class_2(i, quiz[i],"عَمودُ الدّينِ" , "مِفتاحُ الْعِلْمِ", "آفَةُ الْعِلْمِ","مِنْ مَلابِسِ النِّساءِ " ,"کَنْزٌ ","مَزرَعَةُ الْآخِرَةِ ",  javab[i]);
            itemList_moratab_sazi.add(soal);
        }
        adapter_moratab_sazi.notifyDataSetChanged();


    }


}