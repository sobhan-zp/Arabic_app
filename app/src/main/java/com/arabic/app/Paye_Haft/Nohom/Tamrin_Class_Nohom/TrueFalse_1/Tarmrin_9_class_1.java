package com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.TrueFalse_1;

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
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2.Tarmrin_9_class_2;
import com.arabic.app.R;
import com.arabic.app.model.model_9_class.Model_TrueFalse_9_class_1;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class Tarmrin_9_class_1 extends AppCompatActivity {

    private String[] quiz =

            {

                    "عَدَدُ الْأولادِ وَ الْبَناتِ خَمسَةٌِِ", //1
                    "السَّیِّدُ زارعيّ مُدَرِّسُ الْکیمیاءِ", //2
                    "أشجارُ الرُّمّانِ في بُستانِ السَّیِّدِ زارِعيّ",//3
                    "کانَ هَدَفُ الْأولادِ وَ الْبَناتِ مُساعَدَةَ الْجَدِّ والْجَدَّةِ"


            };


    private String[] t =

            {

                   "صحیح",
                   "صحیح",
                   "صحیح",
                   "صحیح"



            };


    private String[] f =

            {

                    "غلط",
                    "غلط",
                    "غلط",
                    "غلط"


            };





    public static int[] ansever =

            {

                    2,
                    2,
                    1,
                    1





            };


    private List<Model_TrueFalse_9_class_1> itemList_user = new ArrayList<>();
    private RecyclerView rv_Tamrin_class_9_1;
    private RecyclerAdaper_Tamrin_9_class_1 adapter_user;

    Button Btn_next1_Tamrin_class_9;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_class_1);
        Fabric.with(this, new Crashlytics());
        save=new SavePref(this);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین در کلاس");

        Log.e("TAg--------", "Tarmrin_9_home_1");


        Btn_next1_Tamrin_class_9 = (Button)findViewById(R.id.Btn_next1_Tamrin_class_9);
        Btn_next1_Tamrin_class_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               /* AppController.CLOSE_ACTIVITY = true;
                finish();*/

                Intent i = new Intent(Tarmrin_9_class_1.this , Tarmrin_9_class_2.class);
                startActivity(i);
            }
        });


        rv_Tamrin_class_9_1 = (RecyclerView) findViewById(R.id.rv_Tamrin_class_9_1);
        adapter_user = new RecyclerAdaper_Tamrin_9_class_1(Tarmrin_9_class_1.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_class_1.this);
        rv_Tamrin_class_9_1.setLayoutManager(mLayoutManager);
        rv_Tamrin_class_9_1.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_class_9_1.setAdapter(adapter_user);


        for (int i = 0; i < 4; i++) {
            Model_TrueFalse_9_class_1 soal = new Model_TrueFalse_9_class_1(i, quiz[i], t[i] ,f[i] , ansever[i]);
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
