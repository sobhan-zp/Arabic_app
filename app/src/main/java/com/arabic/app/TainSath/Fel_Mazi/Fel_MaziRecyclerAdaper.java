package com.arabic.app.TainSath.Fel_Mazi;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.model.Tain_Sath.Fel_Mazi;

import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Fel_MaziRecyclerAdaper extends RecyclerView.Adapter<Fel_MaziRecyclerAdaper.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Fel_Mazi> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private int total_score = 0;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView tv_char2_mazi;
        public RadioButton rb_ch1_mazi, rb_ch2_mazi, rb_ch3_mazi, rb_ch4_mazi, rb_ch5_mazi;


        public MyViewHolder(View view) {
            super(view);

            tv_char2_mazi = (TextView) itemView.findViewById(R.id.tv_char2_mazi);

            rb_ch1_mazi = (RadioButton) itemView.findViewById(R.id.rb_ch1_mazi);
            rb_ch2_mazi = (RadioButton) itemView.findViewById(R.id.rb_ch2_mazi);
            rb_ch3_mazi = (RadioButton) itemView.findViewById(R.id.rb_ch3_mazi);
            rb_ch4_mazi = (RadioButton) itemView.findViewById(R.id.rb_ch4_mazi);
            rb_ch5_mazi = (RadioButton) itemView.findViewById(R.id.rb_ch5_mazi);

        }
    }


    public Fel_MaziRecyclerAdaper(Context context, List<Fel_Mazi> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tainsath_fel_mazi, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Fel_Mazi Item = itemList.get(position);

        holder.tv_char2_mazi.setText(Item.getTitle());
        holder.rb_ch1_mazi.setText(Item.getRb_1_mazi());
        holder.rb_ch2_mazi.setText(Item.getRb_2_mazi());
        holder.rb_ch3_mazi.setText(Item.getRb_3_mazi());
        holder.rb_ch4_mazi.setText(Item.getRb_4_mazi());
        holder.rb_ch5_mazi.setText(Item.getRb_5_mazi());


        holder.rb_ch1_mazi.setTag("1");
        holder.rb_ch2_mazi.setTag("2");
        holder.rb_ch3_mazi.setTag("3");
        holder.rb_ch4_mazi.setTag("4");
        holder.rb_ch5_mazi.setTag("5");


        holder.rb_ch1_mazi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(holder.rb_ch1_mazi, Item.getCorrect());
                }
            }
        });

        holder.rb_ch2_mazi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(holder.rb_ch2_mazi, Item.getCorrect());
                }
            }
        });

        holder.rb_ch3_mazi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(holder.rb_ch3_mazi, Item.getCorrect());
                }
            }
        });

        holder.rb_ch4_mazi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(holder.rb_ch4_mazi, Item.getCorrect());
                }
            }
        });

        holder.rb_ch5_mazi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(holder.rb_ch5_mazi, Item.getCorrect());
                }
            }
        });

        //setAnimation(holder.card_item);
        //setScaleAnimation(holder.click_discount_cardview);
        //setFadeAnimation(holder.card_item);
    }



    private void calc(RadioButton rb , int correct) {

        //save.save(AppController.SAVE_RANK, total_score);

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
