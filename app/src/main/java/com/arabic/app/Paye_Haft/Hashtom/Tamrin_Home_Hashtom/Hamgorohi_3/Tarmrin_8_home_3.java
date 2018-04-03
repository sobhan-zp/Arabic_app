package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Hamgorohi_3;

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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Tarjome_sahih_4.Tarmrin_8_home_4;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_hamgorohi_8_home_3;

import java.util.ArrayList;
import java.util.List;

public class Tarmrin_8_home_3 extends AppCompatActivity {


    private String[] q =

            {

                    "دَخَلَ / خَرَجَ ",
                    "وَراء / خَلف "



            };

    private String[] rb_ch1 =

            {
                    "أ",
                    "کان"


            };


    private String[] rb_ch2 =

            {
                    "مِن",
                    " أمام"

            };


    private String[] rb_ch3 =

            {
                    " ما ",//1
                    " جنب "

            };

    private String[] rb_ch4 =

            {
                    " مَن ",
                    " بین "

            };


    private String[] rb_ch5 =

            {
                    " هل ",
                    " خلف "

            };


    public static int[] ansever =

            {

                    2,
                    1



            };



    private List<Model_hamgorohi_8_home_3> itemList_hm = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_8_3;
    private RecyclerAdaper_Tamrin_8_home_3 adapter_user;


    SavePref save;

    Button Btn_next3_Tamrin_home_8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_8_home_3);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در خانه");

        Log.e("TAg--------", "Tarmrin_8_home_3");

        save = new SavePref(this);

        Btn_next3_Tamrin_home_8 = (Button)findViewById(R.id.Btn_next3_Tamrin_home_8);
        Btn_next3_Tamrin_home_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_3.this, "ترجمه صحیح" + save.load(AppController.SAVE_RANK, 0), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tarmrin_8_home_3.this , Tarmrin_8_home_4.class);
                startActivity(i);
            }
        });


        rv_Tamrin_home_8_3 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_8_3);
        adapter_user = new RecyclerAdaper_Tamrin_8_home_3(Tarmrin_8_home_3.this, itemList_hm);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_8_home_3.this);
        rv_Tamrin_home_8_3.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_8_3.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_8_3.setAdapter(adapter_user);



        for (int i = 0; i < q.length; i++) {
            Model_hamgorohi_8_home_3 soal = new Model_hamgorohi_8_home_3(i, q[i], rb_ch1[i] , rb_ch2[i] , rb_ch3[i] , rb_ch4[i], rb_ch5[i] , ansever[i]);

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

}
