package com.arabic.app.TainSath.Fel_Mazi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.TainSath.Jaye_khali.Tamrin_7_Jaye_khali;
import com.arabic.app.model.Tain_Sath.Fel_Mazi;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_7_fel_mazi extends AppCompatActivity {

    //ListView lvTitleMt;
    String[] quiz_motazad;
    Button tamrinBtn_next5;
    SavePref save;


    private String[] quiz =

            {

                    "النساء وقفنَ لإستقبال ضیوفهنَ",
                    "أَنا إشتَرَیتُ فُستاناً و عَباءهً ",
                    "انتم رجعتم من الجبل ",
                    "ب  ذهبتِ الي سوق النجف  ",
                    " أَنتَ فَتحتَ هَذا اَلبا بَ"


            };

    private int[] javab = {

            1,
            2,
            3,
            4,
            5
    };



    private List<Fel_Mazi> itemList_fel_mazi = new ArrayList<>();
    private RecyclerView rv_tamrin_fm;
    private Fel_MaziRecyclerAdaper adapter_fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_fel_mazi);

        save = new SavePref(this);

        Log.e("TAg--------", "Tamrin_7_fel_mazi");

        // get the string array from string.xml file
       // quiz_motazad = getResources().getStringArray(R.array.quiz_motazad);


        tamrinBtn_next5 = (Button)findViewById(R.id.tamrinBtn_next5);
        tamrinBtn_next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_7_fel_mazi.this, "", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tamrin_7_fel_mazi.this , Tamrin_7_Jaye_khali.class);
                startActivity(i);
            }
        });

        rv_tamrin_fm = (RecyclerView) findViewById(R.id.rv_tamrin_fm);
        adapter_fm = new Fel_MaziRecyclerAdaper(Tamrin_7_fel_mazi.this, itemList_fel_mazi);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_7_fel_mazi.this);
        rv_tamrin_fm.setLayoutManager(mLayoutManager);
        rv_tamrin_fm.setItemAnimator(new DefaultItemAnimator());
        rv_tamrin_fm.setAdapter(adapter_fm);


        for (int i = 0; i < quiz.length; i++) {
            Fel_Mazi soal = new Fel_Mazi(i, quiz[i],"باز کردی " , "رفتی", "برگشتید","خریدم " ,"ایستادند " , javab[i]);
            itemList_fel_mazi.add(soal);
        }
        adapter_fm.notifyDataSetChanged();


    }


}