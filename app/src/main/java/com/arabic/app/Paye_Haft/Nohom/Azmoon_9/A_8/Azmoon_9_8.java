package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_8;

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
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_9.Azmoon_9_9;
import com.arabic.app.R;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_8;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_8 extends AppCompatActivity {

    private String[] quiz =

            {

                    "رَجَعَ: برگشت    رَجَعتُم", //1
                    "فَعَلَ: انجام داد   فَعَلنَ", //2
                    "سَمِحَ: اجازه داد     ما سَمِحَتْ", //3
                    "بَدَأَ:شروع کرد    بدَأُتُن", //4
                    "َجَعَ:برگشت    رَجَعتُما" //5


            };


    private String[] char1 =

            {

                   "شما « دختر ها » برگشتید",//1
                   "آن  « دختر ها » انجام دادند",//2
                   "اجازه  نداد« مذکر  » ",//3
                   " شروع کردیم ",//4
                   "برگشتیم"//5



            };


    private String[] char2 =

            {

                    "شما « پسرها برگشتید» ",//1
                    "ما انجام دادیم ",//2
                    "اجازه  نداد« مونث »",//3
                    " شروع کردید ",//4
                    "برگشتید « مثنی »"//5


            };



    private String[] char3 =

            {

                    "ما برگشتیم",//1
                    "شما«پسرها انجام دادید»",//2
                    "اجازه  ندادم",//3
                    "شروع کردند",//4
                    " برگشتید « جمع »",//5

            };



    public static int[] ansever =

            {

                    2,
                    1,
                    2,
                    2,
                    2



            };


    private List<Model_Azmoon_9_8> itemList_user = new ArrayList<>();
    private RecyclerView rv_azmoon_9_8;
    private RecyclerAdaper_Azmoon_9_8 adapter_user;

    Button Btn_next8_azmoon_8;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_8);

        save=new SavePref(this);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next8_azmoon_8 = (Button)findViewById(R.id.Btn_next8_azmoon_8);
        Btn_next8_azmoon_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_4.this, "next", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Azmoon_9_8.this , Azmoon_9_9.class);
                startActivity(i);
            }
        });


        rv_azmoon_9_8 = (RecyclerView) findViewById(R.id.rv_azmoon_9_8);
        adapter_user = new RecyclerAdaper_Azmoon_9_8(Azmoon_9_8.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_8.this);
        rv_azmoon_9_8.setLayoutManager(mLayoutManager);
        rv_azmoon_9_8.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_8.setAdapter(adapter_user);


        for (int i = 0; i < quiz.length; i++) {
            Model_Azmoon_9_8 soal = new Model_Azmoon_9_8(i, quiz[i], char1[i] ,char2[i],char3[i] , ansever[i]);
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
