package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_5.Azmoon_9_5;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_6.RecyclerAdaper_Azmoon_9_6;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_9.Azmoon_9_9;
import com.arabic.app.R;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_6;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_7;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_7 extends AppCompatActivity {

    private String[] quiz =

            {

                    "اَیَّتُها ....... هَل سَمِعتِ صَوتاً؟", //1
                    "یا وَلَدانِ! ....... سورَةُ!", //2
                    "أنتُنَّ ....... فی المسابقة و  والدیکُنَّ  فَرِحنا  جداً", //3
                    " ....... جلستما هناک", //4
                    " ....... لعبنَ فی المدرسة", //5
                    " ....... نَظَرتُنَّ إلی السماء", //6
                    "کَیْف ....... يا شَيْماءُ وَ يا نَرْجِسُ ؟" //7






            };


    private String[] char1 =

            {

                    "الوالدَةُ ",//1
                    "حَفظتُما ",//2
                    "نَجَحْتُنَّ ",
                    "أنتِ ",
                    "هو ",
                    "أنتم ",
                    "رَجَعْتُم  "

            };


    private String[] char2 =

            {

                    "الوالدُ",
                    "حَفِظتُم",//2
                    "نَجَحْتُمّ",
                    "أنتما ",
                    "هنّ  ",
                    "أنتنَّ ",
                    "رَجَعْتُما"


            };



    public static int[] ansever =

            {

                    1,
                    1,
                    1,
                    2,
                    2,
                    2,
                    2

            };


    private List<Model_Azmoon_9_7> itemList_user = new ArrayList<>();
    private RecyclerView rv_azmoon_9_7;
    private RecyclerAdaper_Azmoon_9_7 adapter_user;

    Button Btn_next7_azmoon_9_7;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_7);

        save=new SavePref(this);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next7_azmoon_9_7 = (Button)findViewById(R.id.Btn_next7_azmoon_9_7);
        Btn_next7_azmoon_9_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_4.this, "next", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Azmoon_9_7.this , Azmoon_9_9.class);
                startActivity(i);
            }
        });


        rv_azmoon_9_7 = (RecyclerView) findViewById(R.id.rv_azmoon_9_7);
        adapter_user = new RecyclerAdaper_Azmoon_9_7(Azmoon_9_7.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_7.this);
        rv_azmoon_9_7.setLayoutManager(mLayoutManager);
        rv_azmoon_9_7.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_7.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_7 soal = new Model_Azmoon_9_7(i, quiz[i], char1[i] ,char2[i] , ansever[i]);
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


    @Override
    public void onBackPressed() {

    }

}
