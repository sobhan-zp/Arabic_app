package com.arabic.app.TainSath.Hamgorohi;

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

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.TainSath.Fel_Mazi.Tamrin_7_fel_mazi;
import com.arabic.app.model.Tain_Sath.Hamgorohi;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_hamgorohi extends AppCompatActivity {


    private String[] q =

            {

                    "دَخَلَ / خَرَجَ ",
                    "وَراء / خَلف ",
                    "غالیه / رخیصة",
                    "سُوء / ُسن",
                    "رَاَیَ / نَظَر"


            };

    private String[] rb_ch1 =

            {
                    " عَین ",
                    " تحت ",
                    " عَشَرَة ",
                    " أخضر ",
                    " حَزِنَ ",

            };


    private String[] rb_ch2 =

            {
                    " قدم ",
                    " جنب ",
                    " خَمسة ",
                    " أفضل ",
                    " عَرفَ ",
            };


    private String[] rb_ch3 =

            {
                    " نَظَرَ ",//1
                    " عند ",
                    " نافذة ",
                    " أبیض ",
                    " حِفظ ",

            };

    private String[] rb_ch4 =

            {
                    " ید ",
                    " حین ",
                    " سِتة ",
                    " اصفر ",
                    " شَرِبَ ",
            };


    private int[] ansever =

            {

                    3,
                    4,
                    3,
                    2,
                    1


            };



    private List<Hamgorohi> itemList_hm = new ArrayList<>();
    private RecyclerView rv_tamrin_hm;
    private HamgorohiRecyclerAdaper adapter_user;


    SavePref save;

    Button tamrinBtn_next4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_hamgorohi);

        Log.e("TAg--------", "Tarmrin_8_home_3");

        save = new SavePref(this);

        tamrinBtn_next4 = (Button)findViewById(R.id.tamrinBtn_next4);
        tamrinBtn_next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_hamgorohi.this, "" + save.load(AppController.SAVE_RANK, 0), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tamrin_hamgorohi.this , Tamrin_7_fel_mazi.class);
                startActivity(i);
            }
        });


        rv_tamrin_hm = (RecyclerView) findViewById(R.id.rv_tamrin_hamgorohi);
        adapter_user = new HamgorohiRecyclerAdaper(Tamrin_hamgorohi.this, itemList_hm);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_hamgorohi.this);
        rv_tamrin_hm.setLayoutManager(mLayoutManager);
        rv_tamrin_hm.setItemAnimator(new DefaultItemAnimator());
        rv_tamrin_hm.setAdapter(adapter_user);



        for (int i = 0; i < q.length; i++) {
          Hamgorohi soal = new Hamgorohi(i, q[i], rb_ch1[i] , rb_ch2[i] , rb_ch3[i] , rb_ch4[i] , ansever[i]);

            itemList_hm.add(soal);
        }
        adapter_user.notifyDataSetChanged();



    }
}
