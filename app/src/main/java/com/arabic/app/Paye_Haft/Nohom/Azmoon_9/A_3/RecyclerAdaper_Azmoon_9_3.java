package com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_3;

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
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Hamgorohi_3.Tarmrin_8_home_3;
import com.arabic.app.R;
import com.arabic.app.model.model_8_home.Model_hamgorohi_8_home_3;
import com.arabic.app.model.model_azmoon_9.Model_Azmoon_9_3;

import java.util.List;

public class RecyclerAdaper_Azmoon_9_3 extends RecyclerView.Adapter<RecyclerAdaper_Azmoon_9_3.ViewHolder> {


    private int lastPosition = -1;
    private boolean iscolor = true;
    private List<Model_Azmoon_9_3> itemList;
    private Context mContext;
    private Typeface font;
    private SavePref save;
    private float total_score = 0;


    private RadioButton rb;
    private int correct;

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public TextView tv_quiz_ch;
        public RadioButton rb_azmoon_9_3_1, rb_azmoon_9_3_2, rb_azmoon_9_3_3, rb_azmoon_9_3_4;


        public Button enterClass;
        Context mContext;

        private Button btn_okk;
        public TextView tv_error, tv_correct;


        public ViewHolder(View itemView) {
            super(itemView);
            // mContext = itemView.getContext();
            rb_azmoon_9_3_1 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_3_1);
            rb_azmoon_9_3_2 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_3_2);
            rb_azmoon_9_3_3 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_3_3);
            rb_azmoon_9_3_4 = (RadioButton) itemView.findViewById(R.id.rb_azmoon_9_3_4);

            //enterClass = (Button) itemView.findViewById(R.id.btn_enterClass_onlineClass);

            tv_error = (TextView) itemView.findViewById(R.id.tv_quiz_row_error);
            tv_correct = (TextView) itemView.findViewById(R.id.tv_quiz_row_correct);
            btn_okk = (Button) itemView.findViewById(R.id.btn_okk);
        }
    }


    public RecyclerAdaper_Azmoon_9_3(Context context, List<Model_Azmoon_9_3> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        save = new SavePref(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_azmoon_9_3, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        final Model_Azmoon_9_3 Item = itemList.get(position);


        viewHolder.rb_azmoon_9_3_1.setText(Item.getRb_1());
        viewHolder.rb_azmoon_9_3_2.setText(Item.getRb_2());
        viewHolder.rb_azmoon_9_3_3.setText(Item.getRb_3());
        viewHolder.rb_azmoon_9_3_4.setText(Item.getRb_4());

        viewHolder.rb_azmoon_9_3_1.setTag("1");
        viewHolder.rb_azmoon_9_3_2.setTag("2");
        viewHolder.rb_azmoon_9_3_3.setTag("3");
        viewHolder.rb_azmoon_9_3_4.setTag("4");

        // shart bandi baraye gozine ha ---->


        // perform setOnCheckedChangeListener event on yes button
        viewHolder.rb_azmoon_9_3_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_azmoon_9_3_1, Item.getCorrect());
                }
            }
        });


        viewHolder.rb_azmoon_9_3_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_azmoon_9_3_2, Item.getCorrect());
                }
            }
        });

        viewHolder.rb_azmoon_9_3_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_azmoon_9_3_3, Item.getCorrect());
                }
            }
        });

        viewHolder.rb_azmoon_9_3_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    calc(viewHolder.rb_azmoon_9_3_4, Item.getCorrect());
                }
            }
        });


        viewHolder.btn_okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /// TODO btn ok
                RadioButton[] rb_all = {
                        viewHolder.rb_azmoon_9_3_1,
                        viewHolder.rb_azmoon_9_3_2,
                        viewHolder.rb_azmoon_9_3_3,
                        viewHolder.rb_azmoon_9_3_4
                };
                if(AppController.checkRadiobutton(rb_all)) return;


                viewHolder.btn_okk.setVisibility(View.GONE);

                if (rb.getTag().toString().equals(String.valueOf(correct))) {
                    //correct
                    viewHolder.tv_correct.setVisibility(View.VISIBLE);
                    viewHolder.tv_correct.setText(rb.getText());

                } else {
                    //error
                    viewHolder.tv_correct.setVisibility(View.VISIBLE);
                    viewHolder.tv_error.setVisibility(View.VISIBLE);


                    String aa = "";
                    switch (Azmoon_9_3.ansever[position]) {
                        case 1:
                            aa = viewHolder.rb_azmoon_9_3_1.getText().toString();
                            break;
                        case 2:
                            aa = viewHolder.rb_azmoon_9_3_2.getText().toString();
                            break;
                        case 3:
                            aa = viewHolder.rb_azmoon_9_3_3.getText().toString();
                            break;
                        case 4:
                            aa = viewHolder.rb_azmoon_9_3_4.getText().toString();
                            break;

                            default:
                                aa = "";
                    }

                    viewHolder.tv_correct.setText(aa);
                    viewHolder.tv_error.setText(rb.getText());

                }


            }
        });


    }




    private void calc(RadioButton rb, int correct) {


        this.rb = rb;
        this.correct = correct;

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
    public void onViewDetachedFromWindow(RecyclerAdaper_Azmoon_9_3.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        //holder.card_item.clearAnimation();
    }

}