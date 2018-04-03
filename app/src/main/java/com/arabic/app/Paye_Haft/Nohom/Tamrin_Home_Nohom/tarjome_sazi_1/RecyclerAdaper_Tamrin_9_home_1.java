package com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.tarjome_sazi_1;

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
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.tarjome_sazi_2.Tarmrin_9_class_2;
import com.arabic.app.R;
import com.arabic.app.model.model_9_class.Model_Tarjome_Sazi_9_class_2;
import com.arabic.app.model.model_9_home.Model_Tarjome_Sazi_9_home_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zp on 12/15/2017.
 */

public class RecyclerAdaper_Tamrin_9_home_1 extends RecyclerView.Adapter<RecyclerAdaper_Tamrin_9_home_1.MyViewHolder> {

    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Model_Tarjome_Sazi_9_home_1> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private List<String> data;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_quiz_row_js;

        private TextView tv_1,
                tv_2,
                tv_3,
                tv_4,
                tv_5,
                tv_6,
                tv_7,
                tv_8;

        private Button btn_1,
                btn_2,
                btn_3,
                btn_4,
                btn_5,
                btn_6,
                btn_7,
                btn_8;

        private Button btn_option, btn_okk;
        public int index = 0;

        private TextView tv_error, tv_correct;

        public MyViewHolder(View view) {
            super(view);

            tv_quiz_row_js = (TextView) itemView.findViewById(R.id.tv_quiz_row_js);

            btn_1 = (Button) itemView.findViewById(R.id.btn_1_tamrin_9_home_1);
            btn_2 = (Button) itemView.findViewById(R.id.btn_2_tamrin_9_home_1);
            btn_3 = (Button) itemView.findViewById(R.id.btn_3_tamrin_9_home_1);
            btn_4 = (Button) itemView.findViewById(R.id.btn_4_tamrin_9_home_1);
            btn_5 = (Button) itemView.findViewById(R.id.btn_5_tamrin_9_home_1);
            btn_6 = (Button) itemView.findViewById(R.id.btn_6_tamrin_9_home_1);
            btn_7 = (Button) itemView.findViewById(R.id.btn_7_tamrin_9_home_1);
            btn_8 = (Button) itemView.findViewById(R.id.btn_8_tamrin_9_home_1);

            btn_option = (Button) itemView.findViewById(R.id.btn_option);
            btn_okk = (Button) itemView.findViewById(R.id.btn_okk);

            tv_error = (TextView) itemView.findViewById(R.id.tv_quiz_row_error);
            tv_correct = (TextView) itemView.findViewById(R.id.tv_quiz_row_correct);

            tv_1 = (TextView) itemView.findViewById(R.id.tv_1_tamrin_9_home_1);
            tv_2 = (TextView) itemView.findViewById(R.id.tv_2_tamrin_9_home_1);
            tv_3 = (TextView) itemView.findViewById(R.id.tv_3_tamrin_9_home_1);
            tv_4 = (TextView) itemView.findViewById(R.id.tv_4_tamrin_9_home_1);
            tv_5 = (TextView) itemView.findViewById(R.id.tv_5_tamrin_9_home_1);
            tv_6 = (TextView) itemView.findViewById(R.id.tv_6_tamrin_9_home_1);
            tv_7 = (TextView) itemView.findViewById(R.id.tv_7_tamrin_9_home_1);
            tv_8 = (TextView) itemView.findViewById(R.id.tv_8_tamrin_9_home_1);


        }
    }


    public RecyclerAdaper_Tamrin_9_home_1(Context context, List<Model_Tarjome_Sazi_9_home_1> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
        data = new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tamrin_9_home_1, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Model_Tarjome_Sazi_9_home_1 Item = itemList.get(position);

        holder.tv_quiz_row_js.setText(Item.getTitle());


        if (Item.getBtn_8() == "") {
            holder.btn_8.setVisibility(View.GONE);
            holder.tv_8.setVisibility(View.GONE);
        } else {
            holder.btn_8.setVisibility(View.VISIBLE);
            holder.tv_8.setVisibility(View.VISIBLE);
        }
        if (Item.getBtn_7() == "") {
            holder.btn_7.setVisibility(View.GONE);
            holder.tv_7.setVisibility(View.GONE);
        } else {
            holder.btn_7.setVisibility(View.VISIBLE);
            holder.tv_7.setVisibility(View.VISIBLE);
        }
        if (Item.getBtn_6() == "") {
            holder.btn_6.setVisibility(View.GONE);
            holder.tv_6.setVisibility(View.GONE);
        } else {
            holder.btn_6.setVisibility(View.VISIBLE);
            holder.tv_6.setVisibility(View.VISIBLE);
        }

        if (Item.getBtn_5() == "") {
            holder.btn_5.setVisibility(View.GONE);
            holder.tv_5.setVisibility(View.GONE);
        } else {
            holder.btn_5.setVisibility(View.VISIBLE);
            holder.tv_5.setVisibility(View.VISIBLE);
        }
        if (Item.getBtn_4() == "") {
            holder.btn_4.setVisibility(View.GONE);
            holder.tv_4.setVisibility(View.GONE);
        } else {
            holder.btn_4.setVisibility(View.VISIBLE);
            holder.tv_4.setVisibility(View.VISIBLE);
        }
        if (Item.getBtn_3() == "") {
            holder.btn_3.setVisibility(View.GONE);
            holder.tv_3.setVisibility(View.GONE);
        } else {
            holder.btn_3.setVisibility(View.VISIBLE);
            holder.tv_3.setVisibility(View.VISIBLE);
        }
        if (Item.getBtn_2() == "") {
            holder.btn_2.setVisibility(View.GONE);
            holder.tv_2.setVisibility(View.GONE);
        } else {
            holder.btn_2.setVisibility(View.VISIBLE);
            holder.tv_2.setVisibility(View.VISIBLE);
        }
        if (Item.getBtn_1() == "") {
            holder.btn_1.setVisibility(View.GONE);
            holder.tv_1.setVisibility(View.GONE);
        } else {
            holder.btn_1.setVisibility(View.VISIBLE);
            holder.tv_1.setVisibility(View.VISIBLE);
        }


        holder.btn_1.setText(Item.getBtn_1());
        holder.btn_2.setText(Item.getBtn_2());
        holder.btn_3.setText(Item.getBtn_3());
        holder.btn_4.setText(Item.getBtn_4());
        holder.btn_5.setText(Item.getBtn_5());
        holder.btn_6.setText(Item.getBtn_6());
        holder.btn_7.setText(Item.getBtn_7());
        holder.btn_8.setText(Item.getBtn_8());

        holder.tv_1.setText(Item.getTv_1());
        holder.tv_2.setText(Item.getTv_2());
        holder.tv_3.setText(Item.getTv_3());
        holder.tv_4.setText(Item.getTv_4());
        holder.tv_5.setText(Item.getTv_5());
        holder.tv_6.setText(Item.getTv_6());
        holder.tv_7.setText(Item.getTv_7());
        holder.tv_8.setText(Item.getTv_8());

        holder.btn_1.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_2.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_3.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_4.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_5.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_6.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_7.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
        holder.btn_8.setBackgroundColor(Color.parseColor("#FFBFBFBF"));

        holder.btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
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
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
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
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
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
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
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
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_5);
            }
        });


        holder.btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_6);
            }
        });

        holder.btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_7);
            }
        });

        holder.btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = null;
                switch (holder.index) {
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
                    case 5:
                        tv = holder.tv_6;
                        break;
                    case 6:
                        tv = holder.tv_7;
                        break;
                    case 7:
                        tv = holder.tv_8;
                        break;
                }
                holder.index++;
                swi(tv, holder.btn_8);
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
                holder.tv_6.setText("");
                holder.tv_7.setText("");
                holder.tv_8.setText("");
                holder.btn_1.setEnabled(true);
                holder.btn_2.setEnabled(true);
                holder.btn_3.setEnabled(true);
                holder.btn_4.setEnabled(true);
                holder.btn_5.setEnabled(true);
                holder.btn_6.setEnabled(true);
                holder.btn_7.setEnabled(true);
                holder.btn_8.setEnabled(true);
                holder.btn_1.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_2.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_3.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_4.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_5.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_6.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_7.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
                holder.btn_8.setBackgroundColor(Color.parseColor("#FFBFBFBF"));
            }
        });

        holder.btn_okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_option.setVisibility(View.GONE);
                holder.btn_okk.setVisibility(View.GONE);

                String all, all2;
                all = holder.tv_1.getText().toString() +
                        holder.tv_2.getText().toString() +
                        holder.tv_3.getText().toString() +
                        holder.tv_4.getText().toString() +
                        holder.tv_5.getText().toString() +
                        holder.tv_6.getText().toString() +
                        holder.tv_7.getText().toString() +
                        holder.tv_8.getText().toString();

                holder.tv_error.setText(all);

                all = all.replace(" ", "").trim();
                all2 = Tarmrin_9_home_1.ANSEVER[position].replace(" ", "").trim();

                holder.tv_correct.setText(Tarmrin_9_home_1.ANSEVER[position]);

                if (all.equals(all2)) {

                    holder.tv_correct.setVisibility(View.VISIBLE);

                    save.save(AppController.SAVE_RANK, (save.load(AppController.SAVE_RANK, 0)) + 1);

                } else {


                    holder.tv_correct.setVisibility(View.VISIBLE);
                    holder.tv_error.setVisibility(View.VISIBLE);

                    save.save(AppController.SAVE_RANK, (save.load(AppController.SAVE_RANK, 0)) - 1);

                }
            }
        });

        //setAnimation(holder.card_item);
        //setScaleAnimation(holder.click_discount_cardview);
        //setFadeAnimation(holder.card_item);
    }

    private void swi(TextView tv, Button btn) {

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
