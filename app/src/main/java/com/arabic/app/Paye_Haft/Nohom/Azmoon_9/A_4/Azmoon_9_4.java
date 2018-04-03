package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_4;

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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Jaye_khali_5.Tarmrin_8_home_5;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Tarjome_sahih_4.RecyclerAdaper_Tamrin_8_home_4;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_3.Azmoon_9_3;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_5.Azmoon_9_5;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_jomleSahih_8_home_4;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_4;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_4 extends AppCompatActivity {

    private String[] quiz =

            {

                    "هل أنتما  الأخوین الاحمدی؟", //1
                    "یا حمیدُ! قَرَأتَ الکتاب  المُفید", //2
                    "الاُستاذُ سَمَحَ لَکَ بِالکَلامِ" //3






            };


    private String[] char1 =

            {

                   "آیا شما  برادر احمدی را دیدی؟",//1
                   "ای حمید ! کتاب های مفید بخوان",//2
                   "استاد به من  اجازه  حرف زدن  می دهد "//3



            };


    private String[] char2 =

            {

                    "آیا شما  دو برادر احمدی هستید؟",
                    "ای حمید! کتاب  مفید را خواندی",//2
                    "استاد به تو اجازه  حرف زدن داد"


            };



    private String[] char3 =

            {

                    "آیا شما  احمدی هستید؟",
                    "ای حمید! کتاب  مفید را خواندند",//2
                    "استاد به تو اجازه  حرف نزدن داد"


            };



    public static int[] ansever =

            {

                    2,
                    2,
                    2



            };


    private List<Model_Azmoon_9_4> itemList_user = new ArrayList<>();
    private RecyclerView rv_azmoon_9_4;
    private RecyclerAdaper_Azmoon_9_4 adapter_user;

    Button Btn_next4_azmoon_4;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_4);

        save=new SavePref(this);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next4_azmoon_4 = (Button)findViewById(R.id.Btn_next4_azmoon_4);
        Btn_next4_azmoon_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_4.this, "next", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Azmoon_9_4.this , Azmoon_9_5.class);
                startActivity(i);
            }
        });


        rv_azmoon_9_4 = (RecyclerView) findViewById(R.id.rv_azmoon_9_4);
        adapter_user = new RecyclerAdaper_Azmoon_9_4(Azmoon_9_4.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_4.this);
        rv_azmoon_9_4.setLayoutManager(mLayoutManager);
        rv_azmoon_9_4.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_4.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_4 soal = new Model_Azmoon_9_4(i, quiz[i], char1[i] ,char2[i],char3[i] , ansever[i]);
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
