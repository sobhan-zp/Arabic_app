package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.tarjome_sazi_1;

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
import com.arabic.app.R;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.moratab_sazi_2.Tamrin_8_class_2;
import com.arabic.app.model.model_8_class.Model_Tarjome_Sazi_8_class_1;


import java.util.ArrayList;
import java.util.List;

public class Tarmrin_8_class_1 extends Activity {


    private String[] quiz = new String[]{

            ". ...ضَرَبْنا لِلنّاسِ في هٰذَا الْقُرآنِ مِنْ کُلِّ مَثَلٍ .   الروم/ ٥٨ ",//1

            "أَ أَنْتَ فَعَلْتَ هٰذا بِآلِهَتِنا يا إبْراهيمُ   . الأنبیا ء  / 62",//2

            "ضَرَبَ لَنا مَثَلاً وَ نَسِيَ خَلْقَهُ.   ياسين/ ۷۸ ",//3

            "نَحنُ ما عَبَرْنا الْحُدودَ. ",//4

            "قالَ الطِّفلُ  « أنَا ما حَزِنْتُ» "//5


    };


    private String[][] button = new String[][]{

            {"مثالی", "دراین قرآن", "برای", "ازهمه", "مثال ها", "از هر ", "زدیم ", "مردم"},//1

            {"انجام دادی", "خدایان ما", "با", "این کار را", "آیا", "چرا?", "خدای ", "تو"},//2

            {"فراموش کرد", "و خلقتش را", "زد ", "مثالی ", "فراموشی می کنی ", "ما", "برای ", "مثال هایی"},//3

            {"عبور نکردیم", " مرزها", "از", "ما", "عبور کردیم", "شما", "عبور نکردید", "محدودیت ها"},//4

            {"ناراحت نشدم", "من", "نیستم", "غمگین", "گفت", "کودک", "می گوید", "فرزند"}//5


    };

    public static String[] ANSEVER = new String[]{

            "زدیم برای مردم در این قرآن از هر مثالی ",

            "آیا تو انجام دادی این کار را با خدایان ما؟",

            "برای ما مثالی زد و خلقتش را فراموش کرد ",

            " ما از مرزها عبور نکردیم ",

            " کودک گفت من ناراحت نشدم "


    };


    private List<Model_Tarjome_Sazi_8_class_1> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_class_8_1;
    private RecyclerAdaper_Tamrin_8_class_1 adapter_user;

    private Button Btn_next1_Tamrin_class_8;
    SavePref save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_8_class_1);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در کلاس");

        Btn_next1_Tamrin_class_8 = (Button) findViewById(R.id.Btn_next1_Tamrin_class_8);
        Btn_next1_Tamrin_class_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_1.this, "", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tarmrin_8_class_1.this, Tamrin_8_class_2.class);
                startActivity(i);
            }
        });


        rv_Tamrin_class_8_1 = (RecyclerView) findViewById(R.id.rv_Tamrin_class_8_1);
        adapter_user = new RecyclerAdaper_Tamrin_8_class_1(Tarmrin_8_class_1.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_8_class_1.this);
        rv_Tamrin_class_8_1.setLayoutManager(mLayoutManager);
        rv_Tamrin_class_8_1.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_class_8_1.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Tarjome_Sazi_8_class_1 soal = new Model_Tarjome_Sazi_8_class_1();
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
