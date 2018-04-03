package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Jaye_khali_5;

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

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_jayeKhali_8_home_5;
import com.arabic.app.model.model_8_home.Model_jomleSahih_8_home_4;

import java.util.ArrayList;
import java.util.List;

public class Tarmrin_8_home_5 extends AppCompatActivity {

    private String[] quiz =

            {

                    " نحنُ   ............لِأخْذِ الْجَوائِزِِ", //1
                    "...ضَرَبْنا لکم أمثالاً متعددةً.", //2
                    "....وَقَعَ عَلی الأرضِ ",//3
                    "أنا.... ملابسکِ ",
                    "عبرنا من الحدود ثمّ.... إلی خارج البلاد  "




            };


    private String[] char1 =

            {

                   "وَقَفُوا",//1
                   "هو",//2
                   "أنت",//3
                   "غَسَلَتْ",//4
                   "ذَهَبْتُ"//5



            };


    private String[] char2 =

            {

                    "وَقَفَنا",
                    "هی",//2
                    "هو",
                    "غَسَلْتُ",
                    "ذَهَبَ"


            };



    private String[] char3 =

            {

                    "وَقَفْتُ",
                    "أنا",//2
                    "أنا",
                    "غسلنا",
                    "ذَهَبْنَا"


            };


    private String[] char4 =

            {

                    "وَقَفَ",
                    "نحن",//2
                    "نحن",
                    "غَسَلْتُن",
                    "ذَهَبْتُن"


            };



    public static int[] ansever =

            {

                    2,
                    4,
                    2,
                    2,
                    3




            };


    private List<Model_jayeKhali_8_home_5> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_8_5;
    private RecyclerAdaper_Tamrin_8_home_5 adapter_user;

    Button Btn_next5_Tamrin_home_8;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_8_home_5);

        save=new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در خانه");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next5_Tamrin_home_8 = (Button)findViewById(R.id.Btn_next5_Tamrin_home_8);
        Btn_next5_Tamrin_home_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AppController.CLOSE_ACTIVITY = true;
                finish();

                /*Intent i = new Intent(Tarmrin_8_home_5.this , Tamrin_7_Dark_Matlab.class);
                startActivity(i);*/
            }
        });


        rv_Tamrin_home_8_5 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_8_5);
        adapter_user = new RecyclerAdaper_Tamrin_8_home_5(Tarmrin_8_home_5.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_8_home_5.this);
        rv_Tamrin_home_8_5.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_8_5.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_8_5.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_jayeKhali_8_home_5 soal = new Model_jayeKhali_8_home_5(i, quiz[i], char1[i] ,char2[i],char3[i],char4[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }



}
