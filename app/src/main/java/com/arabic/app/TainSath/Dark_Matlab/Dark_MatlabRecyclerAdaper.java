package com.arabic.app.TainSath.Dark_Matlab;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.model.Tain_Sath.Dark_Matlab;

import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Dark_MatlabRecyclerAdaper extends RecyclerView.Adapter<Dark_MatlabRecyclerAdaper.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Dark_Matlab> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private int total_score = 0;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_quiz_dm;
        public RadioButton rb_char1_dm, rb_char2_dm;

        public MyViewHolder(View view) {
            super(view);

            tv_quiz_dm = (TextView) itemView.findViewById(R.id.tv_quiz_dm);
            rb_char1_dm = (RadioButton) itemView.findViewById(R.id.rb_char1_dm);
            rb_char2_dm = (RadioButton) itemView.findViewById(R.id.rb_char2_dm);

        }
    }


    public Dark_MatlabRecyclerAdaper(Context context, List<Dark_Matlab> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tainsath_dark_matlab, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Dark_Matlab Item = itemList.get(position);

        holder.tv_quiz_dm.setText(Item.getTitle());
        holder.rb_char1_dm.setText(Item.getRb_char1_dm());
        holder.rb_char2_dm.setText(Item.getRb_char2_dm());

        holder.rb_char1_dm.setTag("1");
        holder.rb_char2_dm.setTag("2");

        holder.rb_char1_dm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_char1_dm, Item.getId_correct());
                }

            }
        });

        holder.rb_char2_dm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_char2_dm, Item.getId_correct());
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
