package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Tarjome_sahih_4;

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
import android.widget.Toast;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Jaye_khali_5.Tarmrin_8_home_5;
import com.arabic.app.R;
import com.arabic.app.TainSath.Dark_Matlab.Tamrin_7_Dark_Matlab;
import com.arabic.app.model.Tain_Sath.Jaye_khali;
import com.arabic.app.model.model_8_home.Model_jomleSahih_8_home_4;

import java.util.ArrayList;
import java.util.List;

public class Tarmrin_8_home_4 extends AppCompatActivity {

    private String[] quiz =

            {

                    " خدا شما را حفظ کند ِ", //1
                    "خدایان ما ", //2
                    "عبرت ها "//3



            };


    private String[] char1 =

            {

                   "حَفظَ اللّه ",//1
                   "آلِهَتِنا ",//2
                   "عُبُور "//3



            };


    private String[] char2 =

            {

                    "حَفِظَکُمُ اللّهُ  ",
                    "إلٰهنا ",//2
                    "ِبَر "


            };



    private String[] char3 =

            {

                    "فی أمان الله",
                    "ربّنا ",//2
                    "عِبَر "


            };



    public static int[] ansever =

            {

                    2,
                    1,
                    3



            };


    private List<Model_jomleSahih_8_home_4> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_8_4;
    private RecyclerAdaper_Tamrin_8_home_4 adapter_user;

    Button Btn_next4_Tamrin_home_8;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_8_home_4);

        save=new SavePref(this);


        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در خانه");

        Log.e("TAg--------", "Tarmrin_8_home_5");


        Btn_next4_Tamrin_home_8 = (Button)findViewById(R.id.Btn_next4_Tamrin_home_8);
        Btn_next4_Tamrin_home_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_8_home_4.this, "next", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tarmrin_8_home_4.this , Tarmrin_8_home_5.class);
                startActivity(i);
            }
        });


        rv_Tamrin_home_8_4 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_8_4);
        adapter_user = new RecyclerAdaper_Tamrin_8_home_4(Tarmrin_8_home_4.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_8_home_4.this);
        rv_Tamrin_home_8_4.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_8_4.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_8_4.setAdapter(adapter_user);


        for (int i = 0; i < 3; i++) {
            Model_jomleSahih_8_home_4 soal = new Model_jomleSahih_8_home_4(i, quiz[i], char1[i] ,char2[i],char3[i] , ansever[i]);
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
