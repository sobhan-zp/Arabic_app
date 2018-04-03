package com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.Hamgorohi_2;

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
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.TrueFals_3.Tarmrin_9_home_3;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_hamgorohi_8_home_3;
import com.arabic.app.model.model_9_home.Model_hamgorohi_9_home_2;

import java.util.ArrayList;
import java.util.List;

public class Tarmrin_9_home_2 extends AppCompatActivity {


    private String[] q =

            {

                    "دَخَلَ        خَرَجَ ",
                    "وَراء        خَلف "



            };

    private String[] rb_ch1 =

            {
                    "رُمان",
                    "والد "


            };


    private String[] rb_ch2 =

            {
                    "عِنَب",
                    " ابن "

            };


    private String[] rb_ch3 =

            {
                    " واقِف ",//1
                    " جَدّ "

            };

    private String[] rb_ch4 =

            {
                    "  تُفّاح ",
                    " بِنت  "

            };





    public static int[] ansever =

            {

                    3,
                    4



            };



    private List<Model_hamgorohi_9_home_2> itemList_hm = new ArrayList<>();
    private RecyclerView rv_Tamrin_home_9_2;
    private RecyclerAdaper_Tamrin_9_home_2 adapter_user;


    SavePref save;

    Button Btn_next2_Tamrin_home_9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarmrin_9_home_2);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("تمرین درخانه");

        Log.e("TAg--------", "Tarmrin_9_home_2");

        save = new SavePref(this);

        Btn_next2_Tamrin_home_9 = (Button)findViewById(R.id.Btn_next2_Tamrin_home_9);
        Btn_next2_Tamrin_home_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Tarmrin_9_home_2.this, "ترجمه صحیح" + save.load(AppController.SAVE_RANK, 0), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tarmrin_9_home_2.this , Tarmrin_9_home_3.class);
                startActivity(i);
            }
        });


        rv_Tamrin_home_9_2 = (RecyclerView) findViewById(R.id.rv_Tamrin_home_9_2);
        adapter_user = new RecyclerAdaper_Tamrin_9_home_2(Tarmrin_9_home_2.this, itemList_hm);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tarmrin_9_home_2.this);
        rv_Tamrin_home_9_2.setLayoutManager(mLayoutManager);
        rv_Tamrin_home_9_2.setItemAnimator(new DefaultItemAnimator());
        rv_Tamrin_home_9_2.setAdapter(adapter_user);



        for (int i = 0; i < q.length; i++) {
            Model_hamgorohi_9_home_2 soal = new Model_hamgorohi_9_home_2(i, q[i], rb_ch1[i] , rb_ch2[i] , rb_ch3[i] , rb_ch4[i], ansever[i]);

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
