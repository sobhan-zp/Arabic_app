package com.arabic.app.TainSath.Motazad;

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
import com.arabic.app.model.Tain_Sath.Motazad;

import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class MotazadRecyclerAdaper extends RecyclerView.Adapter<MotazadRecyclerAdaper.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Motazad> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private int total_score = 0;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView tv_char2_motazad;
        public RadioButton rb_motazad, rb_motradef;


        public MyViewHolder(View view) {
            super(view);

            tv_char2_motazad = (TextView) itemView.findViewById(R.id.tv_char2_motazad);

            rb_motazad = (RadioButton) itemView.findViewById(R.id.yes);
            rb_motradef = (RadioButton) itemView.findViewById(R.id.no);

        }
    }


    public MotazadRecyclerAdaper(Context context, List<Motazad> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tainsath_motazad, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Motazad Item = itemList.get(position);

        holder.tv_char2_motazad.setText(Item.getTitle());
        holder.rb_motazad.setText(Item.getRb_motazad());
        holder.rb_motradef.setText(Item.getRb_motradef());


        if (Item.getCorrect() == 0){
            holder.rb_motazad.setTag("0");
            holder.rb_motradef.setTag("1");
        }else if (Item.getCorrect() == 1){
            holder.rb_motradef.setTag("1");
            holder.rb_motazad.setTag("0");
        }

        holder.rb_motazad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_motazad, Item.getCorrect());
                }

            }
        });

        holder.rb_motradef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    calc(holder.rb_motradef, Item.getCorrect());
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
