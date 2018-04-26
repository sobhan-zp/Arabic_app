package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_3;

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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Hamgorohi_3.RecyclerAdaper_Tamrin_8_home_3;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Tarjome_sahih_4.Tarmrin_8_home_4;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_4.Azmoon_9_4;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_hamgorohi_8_home_3;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_3;

import java.util.ArrayList;
import java.util.List;

public class Azmoon_9_3 extends AppCompatActivity {


    private String[] q =

            {

                    "ضَربتما",
                    "أنتَ",
                    "تَکَلَّم",
                    "ناجِح"



            };

    private String[] rb_ch1 =

            {
                    "ضَربتما",
                    "أنتَ",
                    "تَکَلَّم",
                    "ناجِح"


            };


    private String[] rb_ch2 =

            {
                    "رجعتنَّ",
                    "أنتُم",
                    "قالَ",
                    "فائز"

            };


    private String[] rb_ch3 =

            {
                    "سمعتم",//1
                    "هو",
                    "ذَهَبَ",
                    "نَجَحَ"

            };

    private String[] rb_ch4 =

            {
                    " جمعتُ  ",
                    " أنتُنّ ",
                    " قَرأَ ",
                    " افاضِل "

            };




    public static int[] ansever =

            {

                    4,
                    3,
                    3,
                    4



            };



    private List<Model_Azmoon_9_3> itemList_hm = new ArrayList<>();
    private RecyclerView rv_azmoon_9_3;
    private RecyclerAdaper_Azmoon_9_3 adapter_user;


    SavePref save;

    Button Btn_next3_azmoon_9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azmoon_9_3);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("آزمون درس نهم");

        Log.e("TAg--------", "Tarmrin_8_home_3");

        save = new SavePref(this);

        Btn_next3_azmoon_9 = (Button)findViewById(R.id.Btn_next3_azmoon_9);
        Btn_next3_azmoon_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_3.this, "ترجمه صحیح" + save.load(AppController.SAVE_RANK, 0), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Azmoon_9_3.this , Azmoon_9_4.class);
                startActivity(i);
            }
        });


        rv_azmoon_9_3 = (RecyclerView) findViewById(R.id.rv_azmoon_9_3);
        adapter_user = new RecyclerAdaper_Azmoon_9_3(Azmoon_9_3.this, itemList_hm);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Azmoon_9_3.this);
        rv_azmoon_9_3.setLayoutManager(mLayoutManager);
        rv_azmoon_9_3.setItemAnimator(new DefaultItemAnimator());
        rv_azmoon_9_3.setAdapter(adapter_user);



        for (int i = 0; i < q.length; i++) {
            Model_Azmoon_9_3 soal = new Model_Azmoon_9_3(i, q[i], rb_ch1[i] , rb_ch2[i] , rb_ch3[i] , rb_ch4[i] , ansever[i]);

            itemList_hm.add(soal);
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
