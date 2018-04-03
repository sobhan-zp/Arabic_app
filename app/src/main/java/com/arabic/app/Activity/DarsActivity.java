package com.arabic.app.Activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import io.fabric.sdk.android.Fabric;

public class DarsActivity extends AppCompatActivity {

    SavePref save;
    int requestCode = 200;
    int numberOfDownload = 3;


    //drawble menu
    MaterialDialog profile;
    private Toolbar mToolbar;
    TextView txtMode;
    ImageView profile_close, profile_edit;
    TextView profile_username, profile_password;

    TextView tv_progress;
    LinearLayout linear_download;

    int dlsize = 0, cdl = 0, inc = 0;
    long size = 0;
    boolean state = false;
    File hiddenFilder;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dars);

        Fabric.with(this, new Crashlytics());

        dialog = new ProgressDialog(this);

        logUser();

        // TODO: Use your own attributes to track content views in your app
        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("arabi")
                .putContentType("list_user")
                .putContentId("1234")
                .putCustomAttribute("Favorites Count", 20)
                .putCustomAttribute("Screen Orientation", "Landscape"));


        save = new SavePref(this);
        mToolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        createNav();

        tv_progress = (TextView) findViewById(R.id.tv_base_dl_progress);
        linear_download = (LinearLayout) findViewById(R.id.linear_base_download);

        if (shouldAskPermissions()) {
            askPermissions();
        } else {
            downloading();
        }

        Bundle ex = getIntent().getExtras();
        if (ex != null) {
            if(ex.getString("free").equals("1")){

                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "8");
                startActivity(intent);
                finish();

            }else {
                AppController.DOWNLOAD_FREE_8 = false;
            }
        }

    }



    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("12345");
        Crashlytics.setUserEmail("user@fabric.io");
        Crashlytics.setUserName("Test User");
    }


    // Set Navigation Drawer
    private void createNav() {
        final PrimaryDrawerItem itemHome = new PrimaryDrawerItem().withIdentifier(1).
                withName(R.string.home).
                withSelectable(false)
                .withTextColor(Color.BLACK)
                .withIcon(GoogleMaterial.Icon.gmd_home);


        final SecondaryDrawerItem itemSettings = new SecondaryDrawerItem().withIdentifier(2)
                .withName(R.string.about_app)
                .withSelectable(false)
                .withIcon(GoogleMaterial.Icon.gmd_info);


        final SecondaryDrawerItem itemSearch = new SecondaryDrawerItem().withIdentifier(3)
                .withName(R.string.about_dev)
                .withSelectable(false)
                .withIcon(GoogleMaterial.Icon.gmd_info_outline);


        final SecondaryDrawerItem itemProfile = new SecondaryDrawerItem().withIdentifier(4)
                .withName(R.string.about_pro)
                .withSelectable(false)
                .withIcon(GoogleMaterial.Icon.gmd_account);


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("عربیگرام")
                                .withIcon(getResources()
                                        .getDrawable(R.drawable.logo))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        Drawer build = new DrawerBuilder()
                .withActivity(this)
                .withDrawerGravity(Gravity.LEFT)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        itemHome,
                        new DividerDrawerItem(),
                        itemSearch,
                        itemProfile,
                        itemSettings
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.equals(itemHome)) {
                            Toast.makeText(DarsActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        }
                        if (drawerItem.getIdentifier() == itemSettings.getIdentifier()) {
                            Toast.makeText(DarsActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        }
                        if (drawerItem.getIdentifier() == itemSearch.getIdentifier()) {
                            Toast.makeText(DarsActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        }
                        if (drawerItem.getIdentifier() == itemProfile.getIdentifier()) {
                            ShowProfile();
                            //Toast.makeText(TainSathActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                })
                .withSelectedItem(-1)
                .build();

    }


    private void ShowProfile() {
        profile = new MaterialDialog.Builder(DarsActivity.this)
                .customView(R.layout.alert_profile, false)
                .show();

        profile_close = (ImageView) profile.findViewById(R.id.profile_close);
        profile_edit = (ImageView) profile.findViewById(R.id.profile_edit);
        profile_username = (TextView) profile.findViewById(R.id.profile_username);

        profile_username.setText(save.load(AppController.SAVE_USER_NAME, ""));
        //profile_password.setText(sp.getString("Pass" , null));

        profile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EditprofileActivity.class);
                startActivity(intent);
                //profile.dismiss();
                // edit profile
            }
        });


        profile_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save.save(AppController.SAVE_LOGIN, "0");
                save.save(AppController.SAVE_CHECK_PAYMENT, "0");
                save.save(AppController.SAVE_USER_ID, "0");
                save.save(AppController.SAVE_USER_PAYEH, "0");
                save.save(AppController.SAVE_USER_NAME, "");
                startActivity(new Intent(DarsActivity.this, LoginActivity.class));

                profile.dismiss();
                finish();

                //SharedPreferences.Editor edit = sp.edit();
                //edit.putString("Username" , "");
                //edit.putString("Pass" , "");
                //edit.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    // End Navigation Drawer

    private void downloading() {

        hiddenFilder = new File(Environment.getExternalStorageDirectory().getPath() + "/.arabi/" +
                AppController.DARS_P7_7.substring(AppController.DARS_P7_7.lastIndexOf('/') + 1, AppController.DARS_P7_7.length()));
        if (!hiddenFilder.exists()) {

            hiddenFilder = new File(Environment.getExternalStorageDirectory().getPath() + "/.arabi/");
            hiddenFilder.mkdirs();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    fdl(AppController.DARS_P7_7, AppController.DARS_P7_7.substring(AppController.DARS_P7_7.lastIndexOf('/') + 1, AppController.DARS_P7_7.length()));
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    fdl(AppController.DARS_P7_8, AppController.DARS_P7_8.substring(AppController.DARS_P7_8.lastIndexOf('/') + 1, AppController.DARS_P7_8.length()));
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    fdl(AppController.DARS_P7_9, AppController.DARS_P7_9.substring(AppController.DARS_P7_9.lastIndexOf('/') + 1, AppController.DARS_P7_9.length()));
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    fdl(AppController.DARS_P7_10, AppController.DARS_P7_10.substring(AppController.DARS_P7_10.lastIndexOf('/') + 1, AppController.DARS_P7_10.length()));
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    fdl(AppController.DARS_P7_11, AppController.DARS_P7_11.substring(AppController.DARS_P7_11.lastIndexOf('/') + 1, AppController.DARS_P7_11.length()));
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    fdl(AppController.DARS_P7_12, AppController.DARS_P7_12.substring(AppController.DARS_P7_12.lastIndexOf('/') + 1, AppController.DARS_P7_12.length()));
                }
            }).start();

        } else {
            tv_progress.setText("فایل ها بارگزاری شد");
        }
    }


    private void write() {
        File file = new File(this.getFilesDir(), "mydir");
        if (!file.exists()) {
            file.mkdir();
        }

        try {
            File gpxfile = new File(file, "myfile.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append("hi hi hi hi");
            writer.flush();
            writer.close();

            Toast.makeText(this, "OK: " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();

            Log.e("TAG------", "OK: " + file.getAbsolutePath());
        } catch (Exception e) {
            Log.e("ERROR-----------", e.getMessage());
            e.printStackTrace();
        }
    }


    public void SelectDarsOnclick(View v) {
        switch (v.getId()) {
            case R.id.btn_dars1_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "1");
                startActivity(intent);

                break;
            }

            case R.id.btn_dars2_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "2");
                startActivity(intent);
                break;
            }

            case R.id.btn_dars3_selectdars: {
                Toast.makeText(getApplicationContext(), "soon", Toast.LENGTH_LONG).show();
                break;
            }

            case R.id.btn_dars4_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "1");
                startActivity(intent);

                break;
            }

            case R.id.btn_dars5_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "2");
                startActivity(intent);
                break;
            }

            case R.id.btn_dars6_selectdars: {
                Toast.makeText(getApplicationContext(), "soon", Toast.LENGTH_LONG).show();
                break;
            }

            case R.id.btn_dars7_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "7");
                startActivity(intent);

                break;
            }

            case R.id.btn_dars8_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "8");
                startActivity(intent);
                break;
            }

            case R.id.btn_dars9_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "9");
                startActivity(intent);
                break;
            }

            case R.id.btn_dars10_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "10");
                startActivity(intent);

                break;
            }

            case R.id.btn_dars11_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "11");
                startActivity(intent);
                break;
            }

            case R.id.btn_dars12_selectdars: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                intent.putExtra("file", "12");
                startActivity(intent);
            }


            case R.id.btn_tahlil_selectbase: {
                Toast.makeText(getApplicationContext(), "soon", Toast.LENGTH_LONG).show();
                break;
            }

            default:
                break;
        }

    }


    //tamarin
    public void TamrinSelectDarsOnclick(View v) {
        switch (v.getId()) {
            /*case R.id.btn_tamrin_7: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                startActivity(intent);

                break;
            }*/

            case R.id.btn_tamrin_8: {
                Intent intent = new Intent(getApplicationContext(), ShowPdfActivity.class);
                startActivity(intent);
                break;
            }


            default:
                break;
        }

    }


    private void fdl(String link, String filename) {

        inc++;
        try {

            URL url = new URL(link);
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();

            urlc.setRequestMethod("GET");
            urlc.setDoOutput(true);
            urlc.connect();
            dlsize = urlc.getContentLength();
            size += urlc.getContentLength();

            Log.e("TAG-----", "" + size);

            //File f = new File(Environment.getExternalStorageDirectory(), getname(link));
            File f = new File(hiddenFilder, filename);


            FileOutputStream fo = new FileOutputStream(f);

            InputStream ins = urlc.getInputStream();


            byte[] buffer = new byte[1024];

            int bl = 0;

            while ((bl = ins.read(buffer)) > 0) {

                fo.write(buffer, 0, bl);
                cdl += bl;


                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {

                        float o = ((int) cdl / dlsize) * 100;
                       /* tv_progress.setText((cdl / 1024) + " MB / " + (size / 1024) + "KB - " + (int) o + "%");
                        tv_progress.setText(" در حال دانلود: " + (int) o + "%");*/

                        /*if(((int) o) == 100){
                            tv_progress.setText("دانلود انجام شد");
                        }*/
                    }
                });


            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_progress.setText("دانلود انجام شد");

                    if (inc > numberOfDownload + 1) {
                        //Log.e("TAG--------------", "okkkkk");
                        try {
                            Thread.sleep(3000);
                            linear_download.setVisibility(View.GONE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    inc++;
                }
            });

            //run after download
            /*Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(new File
                    (Environment.getExternalStorageDirectory()+"/"  + getname(l))), "application/vnd.android.package-archive");
            startActivity(intent);*/

            //open pdff file
            //File file = new File(Environment.getExternalStorageDirectory() + "/" + getname(l));
            /*File file = new File(Environment.getExternalStorageDirectory() + "/dars1.pdf");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);*/


            fo.close();


        } catch (final Exception e) {
            runOnUiThread(new Runnable() {
                @SuppressLint("WrongConstant")
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), e.toString(), 3000).show();
                    tv_progress.setText("خطا در دانلود فایل ها! ممکل است سرعت اینترنت شما ضعیف باشد");
                    Log.e("TAG-----------", e.toString());
                }
            });


        }

    }


    private String getname(String link) {

        String[] t = link.split("/");
        int c = t.length;
        String s = t[c - 1];
        s = s.replace("%20", " ");
        return s;

    }


    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }


    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };

        requestPermissions(permissions, requestCode);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 200: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    downloading();

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(DarsActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }






}
