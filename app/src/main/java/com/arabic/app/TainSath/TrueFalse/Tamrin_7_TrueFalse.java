package com.arabic.app.TainSath.TrueFalse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.TainSath.Motazad.Tamrin_7_motazad;
import com.arabic.app.model.Tain_Sath.Truefalse;

import java.util.ArrayList;
import java.util.List;

public class Tamrin_7_TrueFalse extends AppCompatActivity {

    private String[] quiz =

            {

                    "إذا ملک الأراذل هلک الأفاضل ", //1
                    "عملتَ عندی سنوات کثیرةً", //2
                    "التَّجرِبَةُ فَوقَ العلمِ",//3
                    "الفَلّاحتان حَصَدَتا مَحصولَهُما",//4
                    "أَفضَل النّاسِ أَنفعَهُم لِلنّاسِ",//5


            };


    private String[] t =

            {

                    "اگر نادان ها مالک چیزی شوند دانایان هلاک می گردند",
                    "سال های زیادی نزد من کار کردی ",//T-2
                    "تجربه فراتر از علم است ",//T-3
                    "کشاورز محصول را درو کرد ",
                    "بهترین مردم، سودمندترین آن ها برای مردم استِ",//T-5


            };


    private String[] f =

            {

                    "هرگاه فرومایگان فرمانروا شوند شایستگان هلاک می شوند ",//T-1
                    "سال های زیادی نزدت کار کردم",
                    "تجربه مهم تر از علم است ",
                    "کشاورزان محصولشان را درو کردند",//T-4
                    "بهترین مردم، کسی است که برای مردم  سودمند باشد",

            };

    private int[] ansever =

            {

                    1,
                    0,
                    0,
                    1,
                    0


            };


    private List<Truefalse> itemList_user = new ArrayList<>();
    private RecyclerView recyclerView_user;
    private TruefalseRecyclerAdaper adapter_user;

    Button tamrinBtn_next1;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tainsath_true_false);

        save=new SavePref(this);


        tamrinBtn_next1 = (Button)findViewById(R.id.tamrinBtn_next1);
        tamrinBtn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tamrin_7_TrueFalse.this, "", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Tamrin_7_TrueFalse.this , Tamrin_7_motazad.class);
                startActivity(i);
            }
        });


        recyclerView_user = (RecyclerView) findViewById(R.id.rv_tamrin_tf);
        adapter_user = new TruefalseRecyclerAdaper(Tamrin_7_TrueFalse.this, itemList_user);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(Tamrin_7_TrueFalse.this);
        recyclerView_user.setLayoutManager(mLayoutManager);
        recyclerView_user.setItemAnimator(new DefaultItemAnimator());
        recyclerView_user.setAdapter(adapter_user);


        for (int i = 0; i < 5; i++) {
            Truefalse soal = new Truefalse(i, quiz[i], t[i] ,f[i] , ansever[i]);
            itemList_user.add(soal);
        }
        adapter_user.notifyDataSetChanged();


    }



}
