package com.arabic.app.TainSath.Motazad;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.TainSath.JomleSahih.Tamrin_7_jomleSahih;
import com.arabic.app.model.Tain_Sath.Motazad;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_7_motazad extends AppCompatActivity {

    //ListView lvTitleMt;
    String[] quiz_motazad;
    Button tamrinBtn_next2;
    SavePref save;


    private String[] quiz =

            {

                    " دَخَلَ / خَرَج",
                    " وَراء / خَلف ",
                    "غالیه / رخیصة ",
                    " سُوء / ُسن  ",
                    " رَاَیَ / نَظَر",
                    " بارد / حار",
                    "اَجابَ / سَال ",
                    " أفاضل / أراذل",
                    "أفضَل / أراذل "
                    //"أفضَل / خَیر ",
                    //"  َزینۀ / مسرورة"

            };

    private int[] javab = {

            0,
            1,
            0,
            1,
            0,
            0,
            0,
            0,
            1
            //0,
            //0
    };



    private List<Motazad> itemList_motazad = new ArrayList<>();
    private RecyclerView rv_tamrin_mt;
    private MotazadRecyclerAdaper adapter_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_motazad);

        save = new SavePref(this);

        // get the string array from string.xml file
       // quiz_motazad = getResources().getStringArray(R.array.quiz_motazad);


        tamrinBtn_next2 = (Button)findViewById(R.id.tamrinBtn_next2);
        tamrinBtn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_7_motazad.this, "", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tamrin_7_motazad.this , Tamrin_7_jomleSahih.class);
                startActivity(i);
            }
        });

        rv_tamrin_mt = (RecyclerView) findViewById(R.id.rv_tamrin_mt);
        adapter_user = new MotazadRecyclerAdaper(Tamrin_7_motazad.this, itemList_motazad);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_7_motazad.this);
        rv_tamrin_mt.setLayoutManager(mLayoutManager);
        rv_tamrin_mt.setItemAnimator(new DefaultItemAnimator());
        rv_tamrin_mt.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Motazad soal = new Motazad(i, quiz[i], "متضاد", "مترادف", javab[i]);
            itemList_motazad.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }


}