package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.motazad_2;


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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Hamgorohi_3.Tarmrin_8_home_3;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_motazad_8_home_2;

import java.util.ArrayList;
import java.util.List;

public class Tarmrin_8_home_2 extends AppCompatActivity {

    //ListView lvTitleMt;
    String[] quiz_motazad;
    Button Btn_next2_Tamrin_home_8;
    SavePref save;


    private String[] quiz =

            {

                    " فَرِحَ       حَزِنَ",
                    " بِدایة        نَهایة ",
                    "مَوت        حَیاة "


            };

    public static int[] javab = {

            0,
            0,
            0

    };



    private List<Model_motazad_8_home_2> itemList_motazad = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_8_2;
    private RecyclerAdaper_Tamrin_8_home_2 adapter_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_8_home_2);

        save = new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در خانه");

        // get the string array from string.xml file
       // quiz_motazad = getResources().getStringArray(R.array.quiz_motazad);


        Btn_next2_Tamrin_home_8 = (Button)findViewById(R.id.Btn_next2_Tamrin_home_8);
        Btn_next2_Tamrin_home_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_2.this, "کلمات ناهماهنگ", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tarmrin_8_home_2.this ,Tarmrin_8_home_3.class);
                startActivity(i);
            }
        });

        rv_Tamrin_home_8_2 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_8_2);
        adapter_user = new RecyclerAdaper_Tamrin_8_home_2(Tarmrin_8_home_2.this, itemList_motazad);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_8_home_2.this);
        rv_Tamrin_home_8_2.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_8_2.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_8_2.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_motazad_8_home_2 soal = new Model_motazad_8_home_2(i, quiz[i], "متضاد", "مترادف", javab[i]);
            itemList_motazad.add(soal);
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