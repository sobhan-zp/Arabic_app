package com.arabic.app.TainSath.Dark_Matlab;

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

import com.arabic.app.Activity.DoneActivity;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.model.Tain_Sath.Dark_Matlab;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_7_Dark_Matlab extends AppCompatActivity {

    private String[] quiz =

            {

                    "اين لعب ياسر ؟", //1
                    " ماذا فعلَ یاسر حین شاهد أباه ؟", //2
                    "اب الیاسر  فتح البابِ",//3
                    "رجع ياسر الي البيت  بعد الظهر",//4
                    "للیاسر صدیق  واحد ؟",//5


            };


    private String[] char1_dm =

            {

                    " في المدرسه",
                    "فتح الباب ",//T-2
                    "درست ",//T-3
                    "درست ",//T-3
                    "درست "//T-3


            };


    private String[] char2_dm =

            {

                    "في الشارع ",
                    "سَلَّمَ علیه  ",//T-2
                    "نادرست ",//T-3
                    "نادرست ",//T-3
                    "نادرست "//T-3

            };

    private int[] ansever =

            {

                    1,
                    1,
                    1,
                    1,
                    1


            };


    private List<Dark_Matlab> itemList_user = new ArrayList<>();
    private RecyclerView rv_tamrin_jk;
    private Dark_MatlabRecyclerAdaper adapter_user;

    Button tamrinBtn_next7;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_dark_matlab);

        save=new SavePref(this);

        Log.e("TAg--------", "Tamrin_7_Dark_Matlab");

        tamrinBtn_next7 = (Button)findViewById(R.id.tamrinBtn_next7);
        tamrinBtn_next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_7_Dark_Matlab.this, ""+save.load(AppController.SAVE_RANK, 0), Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tamrin_7_Dark_Matlab.this , DoneActivity.class);
                startActivity(i);
            }
        });


        rv_tamrin_jk = (RecyclerView) findViewById(R.id.rv_tamrin_jk);
        adapter_user = new Dark_MatlabRecyclerAdaper(Tamrin_7_Dark_Matlab.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_7_Dark_Matlab.this);
        rv_tamrin_jk.setLayoutManager(mLayoutManager);
        rv_tamrin_jk.setItemAnimator(new DefaultItemAnimator());
        rv_tamrin_jk.setAdapter(adapter_user);


        for (int i = 0; i < 5; i++) {
            Dark_Matlab soal = new Dark_Matlab(i, quiz[i], char1_dm[i] ,char2_dm[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }



}
