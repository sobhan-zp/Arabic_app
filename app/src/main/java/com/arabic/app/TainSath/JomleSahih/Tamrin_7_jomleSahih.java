package com.arabic.app.TainSath.JomleSahih;

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
import com.arabic.app.TainSath.Hamgorohi.Tamrin_hamgorohi;
import com.arabic.app.model.Tain_Sath.JomlehSahih;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_7_jomleSahih extends AppCompatActivity {


    private String[] quiz = new String[]{

            "دوست داشتن  وطن از ایمان است ",//1
            "برترین مردم   مفید ترین  شان برای مردم است ",//2
            "رنگ های پرچم ایران  چیست ؟",//3
            "چه بسا  کلامی که  جوابش سکوت است ",//4
            "بلای انسان در زبانش است ",//5
            "روز شنبه روز  آغاز هفته است "
            //"هرکس  دشمنی بکارد  زیان  درو می کند ",//7
            //"در این  باغ  در ختان  سیب هست ",//8
    };


    private String[][] button = new String[][]{

            {"الإیمانِ ", "حُبّ ", "مِنَ ", "الوطَن ", ""},//1

            {"للناس ", "افضل ", "هم ", "الناس ", ""},//1

            {"ألوان ", "إیران ", "عَلم ", "ماهی ", ""},//1

            {"هُ ", "کلامٍ ", "السکوتُ  ", "جَوابُ  ", "رُبَّ "},//1

            {"ه ", "في ", "الانسان ", "لسان  ", "بلاء "},

            {"الاسبوع ", "السَّبت ", "بدایةِ ", "یومُ", "یومُ "}

            //{ "من","العدوان","الخسران ","حصد","زرع "},

            //{"البُستانِ","فی  ","أشجار","هذا ","التُّفاح  "}
    };

    public static String[] ANSEVER = new String[]{

            "الإیمانِ  حُبّ  مِنَ  الوطَن",
            "للناس  افضل  هم  الناس",
            "ألوان  إیران  عَلم  ماهی",
            "هُ  کلامٍ  السکوتُ   جَوابُ  رُب",
            "ه  في  الانسان  لسان   بلاء",
            "الاسبوع  السَّبت  بدایةِ  یومُ یومُ"

    };

    Button tamrinBtn_next3;
    SavePref save;


    private List<JomlehSahih> itemList_user = new ArrayList<>();
    private RecyclerView rv_tamrin_js;
    private JomlehSahihRecyclerAdaper adapter_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_jomle_sahih);

        tamrinBtn_next3 = (Button) findViewById(R.id.tamrinBtn_next3);
        tamrinBtn_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_7_jomleSahih.this, "", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tamrin_7_jomleSahih.this, Tamrin_hamgorohi.class);
                startActivity(i);
            }
        });


        rv_tamrin_js = (RecyclerView) findViewById(R.id.rv_tamrin_js);
        adapter_user = new JomlehSahihRecyclerAdaper(Tamrin_7_jomleSahih.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_7_jomleSahih.this);
        rv_tamrin_js.setLayoutManager(mLayoutManager);
        rv_tamrin_js.setItemAnimator(new DefaultItemAnimator());
        rv_tamrin_js.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            JomlehSahih soal = new JomlehSahih();
            soal.setId(i + 1);
            soal.setTitle(quiz[i]);
            soal.setBtn_1(button[i][0]);
            soal.setBtn_2(button[i][1]);
            soal.setBtn_3(button[i][2]);
            soal.setBtn_4(button[i][3]);
            soal.setBtn_5(button[i][4]);

            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();

    }


}
