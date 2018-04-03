package com.arabic.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.Jaye_khali_5.Tarmrin_8_home_5;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_1.Azmoon_9_1;
import com.arabic.app.R;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class SplashScreen extends AppCompatActivity {

    private Thread mSplashThread;
    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Fabric.with(this, new Crashlytics());


        save = new SavePref(this);
        save.save(AppController.SAVE_RANK, 0);
        save.save(AppController.SAVE_SCORE_AZMOON, 0f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this,LoginActivity.class));

                //startActivity(new Intent(SplashScreen.this,Azmoon_9_1.class));

                //startActivity(new Intent(SplashScreen.this,DarsActivity.class));

                //startActivity(new Intent(SplashScreen.this,Tarmrin_9_class_1.class));

                //startActivity(new Intent(SplashScreen.this,TainSathActivity.class));
                finish();
            }
        },2000);
    }




}
