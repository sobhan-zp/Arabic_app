package com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.tarjome_sazi_1;

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
import android.widget.Toast;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2.RecyclerAdaper_Tamrin_9_class_2;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2.Tarmrin_9_class_2;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.Hamgorohi_2.Tarmrin_9_home_2;
import com.arabic.app.R;
import com.arabic.app.model.model_9_class.Model_Tarjome_Sazi_9_class_2;
import com.arabic.app.model.model_9_home.Model_Tarjome_Sazi_9_home_1;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class Tarmrin_9_home_1 extends Activity {


    private String[] quiz = new String[]{

            "هَل  فَتَحتُم  بابَ هذِهِ البیوت",//1

            "أنتنَّ نَجَحْتُنَّ فی المسابقة و نحن  فَرِحنا  جداً"//2



    };


    private String[][] button = new String[][]{

            {"خانه ", "آيا", "خانه ها", "چطور", "باز کردید", "اتاق", "این ؟", "در"},//1

            {"موفق شدید", "خوشحال شدیم", "مسابقه", "مسابقات", "موفق شدیم", "شما در", "و ما", "واقعا"}//2




    };

    public static String[] ANSEVER = new String[]{

            "آیا شما در این خانه ها را بازکردید؟",

            "شما در مسابقه موفق شدید و ما واقعا خوشحال شدیم "


    };


    private List<Model_Tarjome_Sazi_9_home_1> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_9_1;
    private RecyclerAdaper_Tamrin_9_home_1 adapter_user;

    private Button Btn_next1_Tamrin_home_9;
    SavePref save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_home_1);
        Fabric.with(this, new Crashlytics());
        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین درخانه");
        Log.e("TAg--------", "Tarmrin_9_home_1");

        Btn_next1_Tamrin_home_9 = (Button) findViewById(R.id.Btn_next1_Tamrin_home_9);
        Btn_next1_Tamrin_home_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_9_home_1.this, "", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tarmrin_9_home_1.this, Tarmrin_9_home_2.class);
                startActivity(i);
            }
        });


        rv_Tamrin_home_9_1 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_9_1);
        adapter_user = new RecyclerAdaper_Tamrin_9_home_1(Tarmrin_9_home_1.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_home_1.this);
        rv_Tamrin_home_9_1.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_9_1.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_9_1.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Tarjome_Sazi_9_home_1 soal = new Model_Tarjome_Sazi_9_home_1();
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


    @Override
    protected void onResume() {
        if(AppController.CLOSE_ACTIVITY){
            AppController.CLOSE_ACTIVITY = false;
            finish();
        }
        super.onResume();
    }
}
