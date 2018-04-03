package com.arabic.app.Activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.CustomRequest;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.crashlytics.android.Crashlytics;
import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog dialog;

    Button btn_login_main;
    TextView edt_email, edt_pass,btn_login_free;

    String active = "0";

    SavePref save;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Fabric.with(this, new Crashlytics());
        save = new SavePref(this);



        if(save.load(AppController.SAVE_LOGIN, "0").equals("1")){
            if(save.load(AppController.SAVE_CHECK_PAYMENT, "0").equals("1")){
                startActivity(new Intent(LoginActivity.this, DarsActivity.class));
                finish();
            }
        }

        dialog = new ProgressDialog(this);

        btn_login_main = (Button) findViewById(R.id.btn_login_main);
        btn_login_free = (Button) findViewById(R.id.btn_login_free);

        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_pass = (EditText) findViewById(R.id.edt_pass);

        btn_login_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(! isNetworkAvailable()) {
                    Toast.makeText(LoginActivity.this, "لطفا اتصال به اینترنت خود را برسی کنید", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(AppController.isValidEmail(edt_email.getText().toString())){
                    dialog.setMessage("login...");
                    dialog.show();
                    Login(edt_email.getText().toString(), edt_pass.getText().toString());
                }else {
                    Toast.makeText(LoginActivity.this, "لطفا ایمیل را درست وارد کنید", Toast.LENGTH_SHORT).show();
                    edt_email.requestFocus();
                }





            }
        });



        btn_login_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppController.DOWNLOAD_FREE_8 = true;

                Intent intent = new Intent(getApplicationContext(), DarsActivity.class);
                intent.putExtra("free", "1");
                startActivity(intent);
            }
        });
    }

    private void Login(String email, String pass) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("email", email);
        params.put("pass", pass);

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, AppController.URL_LOGIN, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject resp = response;
                //Log.e("TAG--------OK", resp.toString());

                String all = "";
                try {
                    all = resp.getString("status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if (Integer.parseInt(all) == 210) {

                    save.save(AppController.SAVE_LOGIN, "1");

                    try {
                        //Log.e("TAG----Active:", resp.getString("active"));

                        save.save(AppController.SAVE_USER_ID, resp.getString("id"));
                        save.save(AppController.SAVE_USER_NAME, resp.getString("fullname"));
                        save.save(AppController.SAVE_CHECK_PAYMENT, resp.getString("active"));
                        active =resp.getString("active");


                        if(active.equals("1")){
                            startActivity(new Intent(LoginActivity.this, DarsActivity.class));
                            finish();
                        }else {
                            String message = "برای استفاده از برنامه لطفا ابتدا پرداخت آنلاین را انجام دهید";
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "در حال انتقال به درگاه پرداخت...", Toast.LENGTH_SHORT).show();
                            requestPayment(edt_email.getText().toString());
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else if (all.equals("204")) {
                    Toast.makeText(LoginActivity.this, "کاربری با این ایمیل یافت نشد", Toast.LENGTH_SHORT).show();
                } else if (all.equals("205")) {
                    Toast.makeText(LoginActivity.this, "کلمه عبور اشتباه است", Toast.LENGTH_SHORT).show();
                }


                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("TAG--------Error", "Error: " + error.getMessage());

                Toast.makeText(LoginActivity.this, "لطفا در زمان دیگری اقدام کنید", Toast.LENGTH_SHORT).show();

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        jsonObjReq.setShouldCache(false);
        //myRequestQueue.getCache().clear();
        AppController.getInstance().addToRequestQueue(jsonObjReq, "LOGIN");

    }


    private void requestPayment(String email) {

        ZarinPal purchase = ZarinPal.getPurchase(this);
        PaymentRequest payment  = ZarinPal.getPaymentRequest();

        payment.setMerchantID(AppController.PAY_MERCHENT_CODE);
        payment.setAmount(AppController.PAY_PRICE);
        payment.setDescription("پرداخت از آپ عربیگرام");
        payment.setCallbackURL("yourapp://app");     /* Your App Scheme */
        //payment.setMobile("09355106005");            /* Optional Parameters */
        if(email.isEmpty()) email = "default@zarinpal.com";
        payment.setEmail(email);     /* Optional Parameters */


        final String finalEmail = email;
        purchase.startPayment(payment, new OnCallbackRequestPaymentListener() {
            @Override
            public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {


                if (status == 100) {
                    /*
                    When Status is 100 Open Zarinpal PG on Browser
                    */
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "پرداخت نا موفق بود لطفا مجدد سعی کنید", Toast.LENGTH_LONG).show();
                    requestPayment(finalEmail);
                }

            }
        });
    }

    public void loginOnClicks(View v) {
        switch (v.getId()) {
            case R.id.tv_login_forget: {
                forgot(edt_email.getText().toString());
                break;
            }
            case R.id.tv_login_register: {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            }
            default:
                break;
        }
    }

    private void forgot(String email) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("email", email);

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, AppController.URL_FORGETPASS, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject resp = response;
                Log.d("TAG--------OK", resp.toString());

                try {
                    if (resp.getString("status").equals("210")) {

                        Toast.makeText(LoginActivity.this, "درخواست تغییر کلمه عبور برای ایمیل شما ارسال شد", Toast.LENGTH_SHORT).show();

                    } else if (resp.getString("status").equals("204")) {
                        Toast.makeText(LoginActivity.this, "کاربری با این ایمیل یافت نشد", Toast.LENGTH_SHORT).show();
                    } else if (resp.getString("status").equals("206")) {
                        Toast.makeText(LoginActivity.this, "خطا در سرور لطفا بعدا سعی کنید", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("TAG--------Error", "Error: " + error.getMessage());

                Toast.makeText(LoginActivity.this, "لطفا در زمان دیگری اقدام کنید", Toast.LENGTH_SHORT).show();

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        jsonObjReq.setShouldCache(false);
        //myRequestQueue.getCache().clear();
        AppController.getInstance().addToRequestQueue(jsonObjReq, "FORGOT");

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
