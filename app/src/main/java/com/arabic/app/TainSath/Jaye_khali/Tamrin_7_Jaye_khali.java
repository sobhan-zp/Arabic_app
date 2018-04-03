package com.arabic.app.TainSath.Jaye_khali;

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
import com.arabic.app.TainSath.Dark_Matlab.Tamrin_7_Dark_Matlab;
import com.arabic.app.model.Tain_Sath.Jaye_khali;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_7_Jaye_khali extends AppCompatActivity {

    private String[] quiz =

            {

                    " .......... سَمحِتُنَّ لی بِالکَلامِ", //1
                    " یا لَیتَنی .......... هذا البَیتَ جَیِّداً", //2
                    "أینَ رَجَعتُنَّ؟ .......... إلی المکتبهِ",//3
                    ".......... ما ذَهَبوا إلی السوق",//4
                    "هولاء الرجال .......... صندوق کنزٍِ",//5
                    "انتما .......... هناٍِ",//6
                    "الاطفال .......... سورتين من القرآنٍِ",//7
                    "الفلاح .......... الريحانٍِ"


            };


    private String[] char1 =

            {

                   "أَنتُنَّ ",//1
                   "صَنَعتَ ",//2
                   "رَجعنا ",//3
                   "هُم ",//4
                   "وجدتُن َ",//5
                   "دخلنا ",//6
                   "حفظوا ",//7
                   "زرعت "


            };


    private String[] char2 =

            {

                    "هُنَّ ",
                    "صَنَعتُ ",//2
                    "رَجَعَتَ ",
                    "هی ",
                    "وجدوا ",//5
                    "جلستما ",//6
                    "حفظن ",
                    "زرع "//8

            };

    private int[] ansever =

            {

                    0,
                    1,
                    0,
                    0,
                    1,
                    1,
                    0,
                    1,


            };


    private List<Jaye_khali> itemList_user = new ArrayList<>();
    private RecyclerView rv_tamrin_jk;
    private Jaye_khalieRecyclerAdaper adapter_user;

    Button tamrinBtn_next6;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_jaye_khali);

        save=new SavePref(this);


        Log.e("TAg--------", "Tarmrin_8_home_5");


        tamrinBtn_next6 = (Button)findViewById(R.id.tamrinBtn_next6);
        tamrinBtn_next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_7_Jaye_khali.this, "", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tamrin_7_Jaye_khali.this , Tamrin_7_Dark_Matlab.class);
                startActivity(i);
            }
        });


        rv_tamrin_jk = (RecyclerView) findViewById(R.id.rv_tamrin_jk);
        adapter_user = new Jaye_khalieRecyclerAdaper(Tamrin_7_Jaye_khali.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_7_Jaye_khali.this);
        rv_tamrin_jk.setLayoutManager(mLayoutManager);
        rv_tamrin_jk.setItemAnimator(new DefaultItemAnimator());
        rv_tamrin_jk.setAdapter(adapter_user);


        for (int i = 0; i < 8; i++) {
            Jaye_khali soal = new Jaye_khali(i, quiz[i], char1[i] ,char2[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }



}
