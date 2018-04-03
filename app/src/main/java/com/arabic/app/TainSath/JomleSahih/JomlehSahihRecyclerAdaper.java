package com.arabic.app.TainSath.JomleSahih;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.model.Tain_Sath.JomlehSahih;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maziar on 12/15/2017.
 */

public class JomlehSahihRecyclerAdaper extends RecyclerView.Adapter<JomlehSahihRecyclerAdaper.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<JomlehSahih> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private List<String> data;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_quiz_row_js;

        public TextView tv_1,
                tv_2,
                tv_3,
                tv_4,
                tv_5
                        ;

        public Button btn_1,
                btn_2,
                btn_3,
                btn_4,
                btn_5
                        ;

        public Button btn_option, btn_okk;
        public int index = 0;

        public MyViewHolder(View view) {
            super(view);

            tv_quiz_row_js = (TextView) itemView.findViewById(R.id.tv_quiz_row_js);

            btn_1 = (Button) itemView.findViewById(R.id.btn_1);
            btn_2 = (Button) itemView.findViewById(R.id.btn_2);
            btn_3 = (Button) itemView.findViewById(R.id.btn_3);
            btn_4 = (Button) itemView.findViewById(R.id.btn_4);
            btn_5 = (Button) itemView.findViewById(R.id.btn_5);

            btn_option = (Button) itemView.findViewById(R.id.btn_option);
            btn_okk = (Button) itemView.findViewById(R.id.btn_okk);

            tv_1 = (TextView) itemView.findViewById(R.id.tv_1);
            tv_2 = (TextView) itemView.findViewById(R.id.tv_2);
            tv_3 = (TextView) itemView.findViewById(R.id.tv_3);
            tv_4 = (TextView) itemView.findViewById(R.id.tv_4);
            tv_5 = (TextView) itemView.findViewById(R.id.tv_5);




        }
    }


    public JomlehSahihRecyclerAdaper(Context context, List<JomlehSahih> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
        data = new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tainsath_jomlesahih, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final JomlehSahih Item = itemList.get(position);

        holder.tv_quiz_row_js.setText(Item.getTitle());

        if(Item.getBtn_5() == ""){
            holder.btn_5.setVisibility(View.GONE);
            holder.tv_5.setVisibility(View.GONE);
        }else {
            holder.btn_5.setVisibility(View.VISIBLE);
            holder.tv_5.setVisibility(View.VISIBLE);
        }
        if(Item.getBtn_4() == ""){
            holder.btn_4.setVisibility(View.GONE);
            holder.tv_4.setVisibility(View.GONE);
        }else {
            holder.btn_4.setVisibility(View.VISIBLE);
            holder.tv_4.setVisibility(View.VISIBLE);
        }
        if(Item.getBtn_3() == ""){
            holder.btn_3.setVisibility(View.GONE);
            holder.tv_3.setVisibility(View.GONE);
        }else {
            holder.btn_3.setVisibility(View.VISIBLE);
            holder.tv_3.setVisibility(View.VISIBLE);
        }
        if(Item.getBtn_2() == ""){
            holder.btn_2.setVisibility(View.GONE);
            holder.tv_2.setVisibility(View.GONE);
        }else {
            holder.btn_2.setVisibility(View.VISIBLE);
            holder.tv_2.setVisibility(View.VISIBLE);
        }
        if(Item.getBtn_1() == ""){
            holder.btn_1.setVisibility(View.GONE);
            holder.tv_1.setVisibility(View.GONE);
        }else {
            holder.btn_1.setVisibility(View.VISIBLE);
            holder.tv_1.setVisibility(View.VISIBLE);
        }


        holder.btn_1.setText(Item.getBtn_1());
        holder.btn_2.setText(Item.getBtn_2());
        holder.btn_3.setText(Item.getBtn_3());
        holder.btn_4.setText(Item.getBtn_4());
        holder.btn_5.setText(Item.getBtn_5());

        holder.tv_1.setText(Item.getTv_1());
        holder.tv_2.setText(Item.getTv_2());
        holder.tv_3.setText(Item.getTv_3());
        holder.tv_4.setText(Item.getTv_4());
        holder.tv_5.setText(Item.getTv_5());

        holder.btn_1.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_2.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_3.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_4.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_5.setBackgroundColor(Color.parseColor("#FFBFBFBF"));

        holder.btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index){
                    case 0:
                        tv = holder.tv_1;
                        break;
                    case 1:
                        tv = holder.tv_2;
                        break;
                    case 2:
                        tv = holder.tv_3;
                        break;
                    case 3:
                        tv = holder.tv_4;
                        break;
                    case 4:
                        tv = holder.tv_5;
                        break;
                }

                holder.index++;
                swi(tv, holder.btn_1);
            }
        });
        holder.btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index){
                    case 0:
                        tv = holder.tv_1;
                        break;
                    case 1:
                        tv = holder.tv_2;
                        break;
                    case 2:
                        tv = holder.tv_3;
                        break;
                    case 3:
                        tv = holder.tv_4;
                        break;
                    case 4:
                        tv = holder.tv_5;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_2);
            }
        });
        holder.btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index){
                    case 0:
                        tv = holder.tv_1;
                        break;
                    case 1:
                        tv = holder.tv_2;
                        break;
                    case 2:
                        tv = holder.tv_3;
                        break;
                    case 3:
                        tv = holder.tv_4;
                        break;
                    case 4:
                        tv = holder.tv_5;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_3);
            }
        });
        holder.btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index){
                    case 0:
                        tv = holder.tv_1;
                        break;
                    case 1:
                        tv = holder.tv_2;
                        break;
                    case 2:
                        tv = holder.tv_3;
                        break;
                    case 3:
                        tv = holder.tv_4;
                        break;
                    case 4:
                        tv = holder.tv_5;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_4);
            }
        });
        holder.btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index){
                    case 0:
                        tv = holder.tv_1;
                        break;
                    case 1:
                        tv = holder.tv_2;
                        break;
                    case 2:
                        tv = holder.tv_3;
                        break;
                    case 3:
                        tv = holder.tv_4;
                        break;
                    case 4:
                        tv = holder.tv_5;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_5);
            }
        });


        holder.btn_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
                holder.index = 0;
                holder.tv_1.setText("");
                holder.tv_2.setText("");
                holder.tv_3.setText("");
                holder.tv_4.setText("");
                holder.tv_5.setText("");
                holder.btn_1.setEnabled(true);
                holder.btn_2.setEnabled(true);
                holder.btn_3.setEnabled(true);
                holder.btn_4.setEnabled(true);
                holder.btn_5.setEnabled(true);
                holder.btn_1.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_2.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_3.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_4.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_5.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
            }
        });

        holder.btn_okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_option.setVisibility(View.GONE);
                holder.btn_okk.setVisibility(View.GONE);

                String all, all2;
                all = holder.tv_1.getText().toString()+
                        holder.tv_2.getText().toString()+
                        holder.tv_3.getText().toString()+
                        holder.tv_4.getText().toString()+
                        holder.tv_5.getText().toString();
                all = all.replace(" ","").trim();
                all2 = Tamrin_7_jomleSahih.ANSEVER[position].replace(" ","").trim();



                if(all.equals(all2)){
                    save.save(AppController.SAVE_RANK, (save.load(AppController.SAVE_RANK, 0)) + 1);

                }else {
                    save.save(AppController.SAVE_RANK, (save.load(AppController.SAVE_RANK, 0)) - 1);

                }
            }
        });

        //setAnimation(holder.card_item);
        //setScaleAnimation(holder.click_discount_cardview);
        //setFadeAnimation(holder.card_item);
    }

    private void swi(TextView tv, Button btn){

        tv.setText(btn.getText().toString());
        btn.setBackgroundColor(Color.parseColor("#D96E6E6E"));
        btn.setEnabled(false);

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
