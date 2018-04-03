package com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Jaye_khali_5;

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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Tarjome_sahih_4.Tarmrin_8_home_4;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_jayeKhali_8_home_5;
import com.arabic.app.model.model_8_home.Model_jomleSahih_8_home_4;

import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class RecyclerAdaper_Tamrin_8_home_5 extends RecyclerView.Adapter<RecyclerAdaper_Tamrin_8_home_5.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Model_jayeKhali_8_home_5> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private int total_score = 0;

    private RadioButton rb;
    private int correct;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_tamrin_8_class_5_title;
        public RadioButton rb_tamrin_8_class_5_1, rb_tamrin_8_class_5_2,rb_tamrin_8_class_5_3,rb_tamrin_8_class_5_4;

        private Button btn_okk;
        public TextView tv_error, tv_correct;

        public MyViewHolder(View view) {
            super(view);

            tv_tamrin_8_class_5_title = (TextView) itemView.findViewById(R.id.tv_tamrin_8_class_5_title);
            rb_tamrin_8_class_5_1 = (RadioButton) itemView.findViewById(R.id.rb_tamrin_8_class_5_1);
            rb_tamrin_8_class_5_2 = (RadioButton) itemView.findViewById(R.id.rb_tamrin_8_class_5_2);
            rb_tamrin_8_class_5_3 = (RadioButton) itemView.findViewById(R.id.rb_tamrin_8_class_5_3);
            rb_tamrin_8_class_5_4 = (RadioButton) itemView.findViewById(R.id.rb_tamrin_8_class_5_4);


            tv_error = (TextView) itemView.findViewById(R.id.tv_quiz_row_error);
            tv_correct = (TextView) itemView.findViewById(R.id.tv_quiz_row_correct);
            btn_okk = (Button) itemView.findViewById(R.id.btn_okk);

        }
    }


    public RecyclerAdaper_Tamrin_8_home_5(Context context, List<Model_jayeKhali_8_home_5> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tamrin_8_home_5, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Model_jayeKhali_8_home_5 Item = itemList.get(position);

        holder.tv_tamrin_8_class_5_title.setText(Item.getTitle());
        holder.rb_tamrin_8_class_5_1.setText(Item.getRb_char1());
        holder.rb_tamrin_8_class_5_2.setText(Item.getRb_char2());
        holder.rb_tamrin_8_class_5_3.setText(Item.getRb_char3());
        holder.rb_tamrin_8_class_5_4.setText(Item.getRb_char4());


        holder.rb_tamrin_8_class_5_1.setTag("1");
        holder.rb_tamrin_8_class_5_2.setTag("2");
        holder.rb_tamrin_8_class_5_3.setTag("3");
        holder.rb_tamrin_8_class_5_4.setTag("4");


        holder.rb_tamrin_8_class_5_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_tamrin_8_class_5_1, Item.getId_correct());
                }

            }
        });

        holder.rb_tamrin_8_class_5_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_tamrin_8_class_5_2, Item.getId_correct());
                }
            }
        });



        holder.rb_tamrin_8_class_5_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_tamrin_8_class_5_3, Item.getId_correct());
                }
            }
        });


        holder.rb_tamrin_8_class_5_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_tamrin_8_class_5_4
                            , Item.getId_correct());
                }
            }
        });



        holder.btn_okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


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
                    switch (Tarmrin_8_home_5.ansever[position]) {
                        case 1:
                            aa = holder.rb_tamrin_8_class_5_1.getText().toString();
                            break;
                        case 2:
                            aa = holder.rb_tamrin_8_class_5_2.getText().toString();
                            break;
                        case 3:
                            aa = holder.rb_tamrin_8_class_5_3.getText().toString();
                            break;
                        case 4:
                            aa = holder.rb_tamrin_8_class_5_4.getText().toString();
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



    private void calc(RadioButton rb , int correct) {


        this.rb = rb;
        this.correct = correct;

        //save.save(AppController.SAVE_RANK, total_score);

        if(rb.getTag().toString().equals(String.valueOf(correct))){
            total_score++;
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
