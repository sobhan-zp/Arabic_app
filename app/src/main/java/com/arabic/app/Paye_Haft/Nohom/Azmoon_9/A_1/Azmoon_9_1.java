package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arabic.app.Activity.DoneActivity;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_2.Azmoon_9_2;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.TrueFalse2_3.Tarmrin_9_class_3;
import com.arabic.app.R;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_1;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class
Azmoon_9_1 extends Activity {


    private String[] quiz = new String[]{

            "بَدَأ جَدَّکُم بالإحسانِ إلیکَ ",//1

            "کان بیتُهم قریباً ببُستانِهِم",//2

            "علیکنَّ بمساعدة أطفالکنَّ",//3

            "أیّتُها البَناتُ ! جَمِعتُنَّ کُتُبَهنّ "//4



    };


    private String[][] button = new String[][]{

            {"شروع کرد", "نیکی کردن", "شروع می کند", "مادربزرگ", "شما", "پدربزرگ", "به تو" , "به"},//1

            {"آن ها", "نزدیک", "باغشان", "به", "نزدیک تر", "بود", "خانه", "خانه های"},//2

            {"نباید", "شما«مردان»", "کمک کنید", "فرزندانتان", "به", "باید", "شما«زنان»", "فرزندتان"},//3

            {"کتابهایشان", "ای خواهران", "جمع کنید", "ای دختران", "را", "کتاب هایتان", "جمع کردید" , "کتابتان"}//4



    };

    public static String[] ANSEVER = new String[]{

            "شروع کرد پدر بزرگ شما به نیکی کردن به تو",

            "بود خانه آنها نزدیک  به باغشان",

            "شما باید کمک کنید به فرزندانتان",

            "ای دختران جمع کردید کتاب هایتان را"




    };


    private List<Model_Azmoon_9_1> itemList_user = new ArrayList<>();
    private RecyclerView rv_azmoon_9_1;
    private RecyclerAdaper_Azmoon_9_1 adapter_user;

    private Button Btn_next1_azmoon_9_1;
    SavePref save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_1);
        Fabric.with(this, new Crashlytics());
        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("CLASS", Azmoon_9_1.class.getName().toString());

        save = new SavePref(this);

        save.save(AppController.SAVE_SCORE_AZMOON, 0f);

        Btn_next1_azmoon_9_1 = (Button) findViewById(R.id.Btn_next1_azmoon_9_1);
        Btn_next1_azmoon_9_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_9_class_2.this, "", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Azmoon_9_1.this, Azmoon_9_2.class);
                startActivity(i);
            }
        });


        rv_azmoon_9_1 = (RecyclerView) findViewById(R.id.rv_azmoon_9_1);
        adapter_user = new RecyclerAdaper_Azmoon_9_1(Azmoon_9_1.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_1.this);
        rv_azmoon_9_1.setLayoutManager(mLayoutManager);
        rv_azmoon_9_1.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_1.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_1 soal = new Model_Azmoon_9_1();
            soal.setId(i + 1);
            soal.setTitle(quiz[i]);
            soal.setBtn_1(button[i][0]);
            soal.setBtn_2(button[i][1]);
            soal.setBtn_3(button[i][2]);
            soal.setBtn_4(button[i][3]);
            soal.setBtn_5(button[i][4]);
            soal.setBtn_6(button[i][5]);
            soal.setBtn_7(button[i][6]);
            soal.setBtn_8(button[i][7]);

            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }
/*
    int score = extra.getInt("SCORE");
    int totalQuestion = extra.getInt("TOTAL");
    int correctAnswer = extra.getInt("CORRECT");*/


    @Override
    protected void onResume() {
        if(AppController.CLOSE_ACTIVITY){
            AppController.CLOSE_ACTIVITY = false;

            Intent intent = new Intent(Azmoon_9_1.this, DoneActivity.class);
            intent.putExtra("SCORE",  ""+save.load(AppController.SAVE_SCORE_AZMOON, 0f));
            intent.putExtra("MODE", 1); //for azmoon
            startActivity(intent);

            finish();
        }
        super.onResume();
    }

    @Override
    public void onBackPressed() {

    }
}
