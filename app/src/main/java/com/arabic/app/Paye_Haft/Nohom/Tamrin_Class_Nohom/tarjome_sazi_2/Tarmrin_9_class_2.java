package com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2;

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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.moratab_sazi_2.Tamrin_8_class_2;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.TrueFalse2_3.Tarmrin_9_class_3;
import com.arabic.app.R;
import com.arabic.app.model.model_9_class.Model_Tarjome_Sazi_9_class_2;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class Tarmrin_9_class_2 extends Activity {


    private String[] quiz = new String[]{

            "یا بِنْتانِ، کَيْفَ قَرَأْتُما دَرسَکُما؟",//1

            "أيُّها الطُّلّابُ، لِماذا فَتَحْتُمْ أَبْوابَ الصُّفوفِ؟",//2

            "أیَّتُهَا السَّیِّداتُ، أَ سَمِعْتُنَّ صَوْتَ أطفالِکُنَّ؟",//3

            "یا أُستاذُ، هَلْ سَمَحْتَ لي بِالْکَلامِ؟"//4



    };


    private String[][] button = new String[][]{

            {"ای دخترها", "را", "چطور", "آیا", "درستان", "خواندید", "درسهایشان" , ""},//1

            {"را", "کلاس ها", "کلاس", "درهای", "ای دانش آموزان", "چرا", "باز کردید", ""},//2

            {"را", "بچهایشان", "آن خانم ها", "بچه هایتان", "صدای", "آیا ", "شنیدند", "ای خانم ها"},//3

            {"دادی", "به من", "آیا", "استاد", "حرف بزنم", "داد", "اجازه" , ""}//4



    };

    public static String[] ANSEVER = new String[]{

            "ای دخترها چطور خواندید درستان را",

            "ای دانش آموزان چرا باز کردید درهای کلاس را؟",

            "ای خانم ها آیا شنیدید صدای بچه هایتان را",

            "استاد آیا به من اجازه دادی  حرف بزنم"




    };


    private List<Model_Tarjome_Sazi_9_class_2> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_class_9_2;
    private RecyclerAdaper_Tamrin_9_class_2 adapter_user;

    private Button btn_next2_Tamrin_class_9;
    SavePref save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_class_2);
        Fabric.with(this, new Crashlytics());
        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در کلاس");

        Log.e("TAg--------", "Tarmrin_9_home_2");

        btn_next2_Tamrin_class_9 = (Button) findViewById(R.id.Btn_next2_Tamrin_class_9);
        btn_next2_Tamrin_class_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_9_class_2.this, "", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tarmrin_9_class_2.this, Tarmrin_9_class_3.class);
                startActivity(i);
            }
        });


        rv_Tamrin_class_9_2 = (RecyclerView) findViewById(R.id.rv_Tamrin_class_9_2);
        adapter_user = new RecyclerAdaper_Tamrin_9_class_2(Tarmrin_9_class_2.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_class_2.this);
        rv_Tamrin_class_9_2.setLayoutManager(mLayoutManager);
        rv_Tamrin_class_9_2.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_class_9_2.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Tarjome_Sazi_9_class_2 soal = new Model_Tarjome_Sazi_9_class_2();
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
            finish();
        }
        super.onResume();
    }
}
