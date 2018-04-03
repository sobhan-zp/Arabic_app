package com.arabic.app.TainSath.Hamgorohi;

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
import com.arabic.app.R;
import com.arabic.app.model.Tain_Sath.Hamgorohi;

import java.util.List;

public class HamgorohiRecyclerAdaper extends RecyclerView.Adapter<HamgorohiRecyclerAdaper.ViewHolder> {


    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Hamgorohi> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private int total_score = 0;


    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public TextView tv_quiz_ch;
        public RadioButton rb_ch1, rb_ch2, rb_ch3, rb_ch4;


        public Button enterClass;
        Context mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            // mContext = itemView.getContext();
            rb_ch1 = (RadioButton) itemView.findViewById(R.id.rb_ch1);
            rb_ch2 = (RadioButton) itemView.findViewById(R.id.rb_ch2);
            rb_ch3 = (RadioButton) itemView.findViewById(R.id.rb_ch3);
            rb_ch4 = (RadioButton) itemView.findViewById(R.id.rb_ch4);

            //enterClass = (Button) itemView.findViewById(R.id.btn_enterClass_onlineClass);

        }
    }


    public HamgorohiRecyclerAdaper(Context context, List<Hamgorohi> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_tainsath_hamgorohi, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        final Hamgorohi Item = itemList.get(position);


        viewHolder.rb_ch1.setText(Item.getRb_1());
        viewHolder.rb_ch2.setText(Item.getRb_2());
        viewHolder.rb_ch3.setText(Item.getRb_3());
        viewHolder.rb_ch4.setText(Item.getRb_4());

        viewHolder.rb_ch1.setTag("1");
        viewHolder.rb_ch2.setTag("2");
        viewHolder.rb_ch3.setTag("3");
        viewHolder.rb_ch4.setTag("4");

        // shart bandi baraye gozine ha ---->


        // perform setOnCheckedChangeListener event on yes button
        viewHolder.rb_ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_ch1, Item.getCorrect());
                }
            }
        });


        viewHolder.rb_ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_ch2, Item.getCorrect());
                }
            }
        });

        viewHolder.rb_ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_ch3, Item.getCorrect());
                }
            }
        });

        viewHolder.rb_ch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_ch4, Item.getCorrect());
                }
            }
        });



    }


        private void calc(RadioButton rb , int correct) {


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
    public void onViewDetachedFromWindow(HamgorohiRecyclerAdaper.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        //holder.card_item.clearAnimation();
    }

}