package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.tarjome_sazi_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.motazad_2.Tarmrin_8_home_2;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_Tarjome_Sazi_8_home_1;

import java.util.ArrayList;
import java.util.List;

public class Tarmrin_8_home_1 extends Activity {


    private String[] quiz = new String[]{

            "هِي ما عَرَفَتْ مُعَلّمَها   ",//1

            "نَحنُ وَصَلنا ألي مَدینَةِ مِهِرانِ في الحُدودِ "//2


    };


    private String[][] button = new String[][]{

            {"را", "معلمش", "نشناخت", "او« دختر»" ,"شما" , "او « پسر»" , "" , ""},//1

            { "مهران", "رسیدیم", "در  مرزها", "به شهر", "ما","چرا" , "برای" , ""}//2

    };

    public static String[] ANSEVER = new String[]{

            "او «دختر» نشناخت معلمش را",

            "ما رسیدیم به شهر مهران در مرزها"

    };


    private List<Model_Tarjome_Sazi_8_home_1> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_8_1;
    private RecyclerAdaper_Tamrin_8_home_1 adapter_user;

    private Button Btn_next1_Tamrin_home_8;
    SavePref save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_8_home_1);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در خانه");

        Btn_next1_Tamrin_home_8 = (Button) findViewById(R.id.Btn_next1_Tamrin_home_8);
        Btn_next1_Tamrin_home_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_1.this, "", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tarmrin_8_home_1.this, Tarmrin_8_home_2.class);
                startActivity(i);
            }
        });


        rv_Tamrin_home_8_1 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_8_1);
        adapter_user = new RecyclerAdaper_Tamrin_8_home_1(Tarmrin_8_home_1.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_8_home_1.this);
        rv_Tamrin_home_8_1.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_8_1.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_8_1.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Tarjome_Sazi_8_home_1 soal = new Model_Tarjome_Sazi_8_home_1();
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
