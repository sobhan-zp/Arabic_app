package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_7;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_6.Azmoon_9_6;
import com.arabic.app.R;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_6;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_7;

import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class RecyclerAdaper_Azmoon_9_7 extends RecyclerView.Adapter<RecyclerAdaper_Azmoon_9_7.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Model_Azmoon_9_7> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private float total_score = 0;


    private RadioButton rb;
    private int correct;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_azmoon_9_7_title;
        public RadioButton rb_azmoon_9_7_1, rb_azmoon_9_7_2;

        private Button btn_okk;
        public TextView tv_error, tv_correct;


        public MyViewHolder(View view) {
            super(view);

            tv_azmoon_9_7_title = (TextView) itemView.findViewById(R.id.tv_azmoon_9_7_title);
            rb_azmoon_9_7_1 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_7_1);
            rb_azmoon_9_7_2 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_7_2);
            //    rb_azmoon_9_7_3 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_7_3);


            tv_error = (TextView) itemView.findViewById(R.id.tv_quiz_row_error);
            tv_correct = (TextView) itemView.findViewById(R.id.tv_quiz_row_correct);
            btn_okk = (Button) itemView.findViewById(R.id.btn_okk);
        }
    }


    public RecyclerAdaper_Azmoon_9_7(Context context, List<Model_Azmoon_9_7> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_azmoon_9_7, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Model_Azmoon_9_7 Item = itemList.get(position);

        holder.tv_azmoon_9_7_title.setText(Item.getTitle());
        holder.rb_azmoon_9_7_1.setText(Item.getRb_char1());
        holder.rb_azmoon_9_7_2.setText(Item.getRb_char2());
        //holder.rb_azmoon_9_7_3.setText(Item.getRb_char3());


        holder.rb_azmoon_9_7_1.setTag("1");
        holder.rb_azmoon_9_7_2.setTag("2");
        // holder.rb_azmoon_9_7_3.setTag("3");


        holder.rb_azmoon_9_7_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_azmoon_9_7_1, Item.getId_correct());
                }

            }
        });

        holder.rb_azmoon_9_7_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_azmoon_9_7_2, Item.getId_correct());
                }
            }
        });


        holder.btn_okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RadioButton[] rb_all = {
                        holder.rb_azmoon_9_7_1,
                        holder.rb_azmoon_9_7_2

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
                    switch (Azmoon_9_7.ansever[position]) {
                        case 1:
                            aa = holder.rb_azmoon_9_7_1.getText().toString();
                            break;
                        case 2:
                            aa = holder.rb_azmoon_9_7_2.getText().toString();
                            break;


                    }

                    holder.tv_correct.setText(aa);
                    holder.tv_error.setText(rb.getText());

                }


            }
        });


        //setAnimation(holder.card_item);
        //setScaleAnimation(holder.click_discount_cardview);
        //setFadeAnimation(holder.card_item);
    }


    private void calc(RadioButton rb, int correct) {

        this.rb = rb;
        this.correct = correct;


        //save.save(AppController.SAVE_SCORE_AZMOON, total_score);

        if (rb.getTag().toString().equals(String.valueOf(correct))) {
            total_score += 0.55f;
        } else {
            if (total_score != 0) total_score -= 0.55f;
        }

        save.save(AppController.SAVE_SCORE_AZMOON, total_score);

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
