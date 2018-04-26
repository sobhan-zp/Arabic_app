package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.motazad_2;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.moratab_sazi_2.Tamrin_8_class_2;
import com.arabic.app.R;
import com.arabic.app.model.Tain_Sath.Motazad;
import com.arabic.app.model.model_8_home.Model_motazad_8_home_2;

import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class RecyclerAdaper_Tamrin_8_home_2 extends RecyclerView.Adapter<RecyclerAdaper_Tamrin_8_home_2.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Model_motazad_8_home_2> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private int total_score = 0;

    private RadioButton rb;
    private int correct;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView tv_tamrin_8_class_2_title;
        public RadioButton rb_tamrin_8_class_2_yes, rb_tamrin_8_class_2_no;

        private Button btn_okk;
        public TextView tv_error, tv_correct;

        public MyViewHolder(View view) {
            super(view);

            tv_tamrin_8_class_2_title = (TextView) itemView.findViewById(R.id.tv_tamrin_8_class_2_title);

            rb_tamrin_8_class_2_yes = (RadioButton) itemView.findViewById(R.id.rb_tamrin_8_class_2_yes);
            rb_tamrin_8_class_2_no = (RadioButton) itemView.findViewById(R.id.rb_tamrin_8_class_2_no);

            tv_error = (TextView) itemView.findViewById(R.id.tv_quiz_row_error);
            tv_correct = (TextView) itemView.findViewById(R.id.tv_quiz_row_correct);
            btn_okk = (Button) itemView.findViewById(R.id.btn_okk);
        }
    }


    public RecyclerAdaper_Tamrin_8_home_2(Context context, List<Model_motazad_8_home_2> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tamrin_8_home_2, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Model_motazad_8_home_2 Item = itemList.get(position);

        holder.tv_tamrin_8_class_2_title.setText(Item.getTitle());
        holder.rb_tamrin_8_class_2_no.setText(Item.getRb_motazad());
        holder.rb_tamrin_8_class_2_yes.setText(Item.getRb_motradef());


        if (Item.getCorrect() == 0){
            holder.rb_tamrin_8_class_2_no.setTag("0");
            holder.rb_tamrin_8_class_2_yes.setTag("1");
        }else if (Item.getCorrect() == 1){
            holder.rb_tamrin_8_class_2_no.setTag("1");
            holder.rb_tamrin_8_class_2_yes.setTag("0");
        }

        holder.rb_tamrin_8_class_2_no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_tamrin_8_class_2_no, Item.getCorrect());
                }

            }
        });

        holder.rb_tamrin_8_class_2_yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_tamrin_8_class_2_yes, Item.getCorrect());
                }
            }
        });


        //setAnimation(holder.card_item);
        //setScaleAnimation(holder.click_discount_cardview);
        //setFadeAnimation(holder.card_item);

        holder.btn_okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /// TODO btn ok
                RadioButton[] rb_all = {
                        holder.rb_tamrin_8_class_2_no,
                        holder.rb_tamrin_8_class_2_yes

                };
                if(AppController.checkRadiobutton(rb_all)) return;

                holder.btn_okk.setVisibility(View.GONE);

                if (rb.getTag().toString().equals(String.valueOf(correct))) {
                    //correct
                    holder.tv_correct.setVisibility(View.VISIBLE);
                    holder.tv_correct.setText(rb.getText());

                } else {
                    //error
                    holder.tv_correct.setVisibility(View.VISIBLE);
                    holder.tv_error.setVisibility(View.VISIBLE);


                    String aa = "";
                    switch (Tarmrin_8_home_2.javab[position]) {
                        case 0:
                            aa = holder.rb_tamrin_8_class_2_no.getText().toString();
                            break;
                        case 1:
                            aa = holder.rb_tamrin_8_class_2_yes.getText().toString();
                            break;
                    }

                    holder.tv_correct.setText(aa);
                    holder.tv_error.setText(rb.getText());

                }


            }
        });

    }



    private void calc(RadioButton rb , int correct) {

        //save.save(AppController.SAVE_RANK, total_score);

        this.rb = rb;
        this.correct = correct;

        if(rb.getTag().toString().equals(String.valueOf(correct))){
            total_score++;
            Log.e("TAG", ""+total_score);
        }else {
            if (total_score !=0) total_score--;
        }

        save.save(AppController.SAVE_RANK, total_score);

        //Log.e("TAG", "total_score:::::"+ total_score);

    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /*private void setAnimation(View viewToAnimate) {

        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.up_from_bottom);
        animation.setDuration(1000);
        viewToAnimate.startAnimation(animation);


    }*/


    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        //holder.card_item.clearAnimation();
    }


}
