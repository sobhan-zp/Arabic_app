package com.arabic.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.arabic.app.TainSath.TrueFalse.Tamrin_7_TrueFalse;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class TainSathActivity extends AppCompatActivity {




    SavePref save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tainsath);

        Fabric.with(this, new Crashlytics());

        save = new SavePref(this);

        findview();




    }


    public void SelectBaseOnclick(View v) {
        switch (v.getId()) {
            case R.id.btn_base7_selectbase: {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //intent.putExtra("MODE",getPlayMode()); // Send Mode to Playing page
                startActivity(intent);
                //finish();
                break;
            }

            case R.id.btn_base8_selectbase: {
                Intent intent = new Intent(getApplicationContext(), Tamrin_7_TrueFalse.class);
                //intent.putExtra("MODE",getPlayMode()); // Send Mode to Playing page
                startActivity(intent);
                //finish();
                break;
            }
            case R.id.btn_base9_selectbase: {
                Toast.makeText(getApplicationContext(), "بزودی", Toast.LENGTH_LONG).show();
                //finish();
                break;
            }
            case R.id.btn_tahlil_selectbase: {
                Toast.makeText(getApplicationContext(), "بزودی", Toast.LENGTH_LONG).show();
                break;
            }

            default:
                break;
        }

    }


    private void findview() {
        //bottom navigation
        //seekBar = (SeekBar)findViewById(R.id.seekBar);
        //txtMode = (TextView)findViewById(R.id.txtMode);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
// Navigation Drawer Navigation Drawer Navigation Drawer




