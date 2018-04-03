package com.arabic.app.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.arabic.app.Network.AppController;
import com.arabic.app.Network.CustomRequest;
import com.arabic.app.Network.SavePref;
import com.arabic.app.R;
import com.crashlytics.android.Crashlytics;
import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.OnCallbackVerificationPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class RegisterActivity extends AppCompatActivity {

    ProgressDialog dialog;
    Spinner spRegisterTeacher;
    ArrayList<String> ostadName, idostad;
    ArrayAdapter adapter;
    EditText edt_fullname, edt_email, edt_pass, edt_conf_pass;

    SavePref save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Fabric.with(this, new Crashlytics());

        save = new SavePref(this);


        Uri data = getIntent().getData();
        ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
            @Override
            public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {


                if (isPaymentSuccess) {
                    save.save(AppController.SAVE_CHECK_PAYMENT, "1");
                    updateActiveUser(save.load(AppController.SAVE_USER_ID, "-1"));

                } else {
                    /* When Payment Request is Failure :) */
                    String message = "برای استفاده از برنامه لطفا ابتدا پرداخت آنلاین را انجام دهید";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegisterActivity.this, "در حال انتقال به درگاه پرداخت...", Toast.LENGTH_SHORT).show();
                    requestPayment("");
                }


            }
        });



        if(save.load(AppController.SAVE_LOGIN, "0").equals("1")){
            if(save.load(AppController.SAVE_CHECK_PAYMENT, "0").equals("1")){
                startActivity(new Intent(RegisterActivity.this, DarsActivity.class));
                finish();
            }
        }

        dialog = new ProgressDialog(this);

        edt_fullname = (EditText) findViewById(R.id.edt_reg_fullname);
        edt_email = (EditText) findViewById(R.id.edt_reg_email);
        edt_pass = (EditText) findViewById(R.id.edt_reg_pass);
        edt_conf_pass = (EditText) findViewById(R.id.edt_reg_conf_pass);

        fillOstad();
    }

    private void fillOstad() {

        ostadName = new ArrayList<>();
        idostad = new ArrayList<>();

        spRegisterTeacher = (Spinner) findViewById(R.id.sp_register_teacher);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ostadName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRegisterTeacher.setAdapter(adapter);

        JsonArrayRequest req = new JsonArrayRequest(AppController.URL_OSTAD,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d("TAG---------OK", response.toString());

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                idostad.add(object.getString("id"));
                                ostadName.add(object.getString("fname") + " " +
                                        object.getString("lname"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG------------Error", "Error: " + error.getMessage());

            }
        });
        req.setShouldCache(false);
        AppController.getInstance().addToRequestQueue(req, "OSTAD_NAME");
    }


    public void registerOnClicks(View v) {
        switch (v.getId()) {
            case R.id.tv_register_login: {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            }
            case R.id.btn_register_main: {


                if(! isNetworkAvailable()) {
                    Toast.makeText(RegisterActivity.this, "لطفا اتصال به اینترنت خود را برسی کنید", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(AppController.isValidEmail(edt_email.getText().toString())){

                    dialog.setMessage("register please wait...");
                    dialog.show();
                    register(edt_fullname.getText().toString(),
                            edt_email.getText().toString(),
                            edt_pass.getText().toString(),
                            idostad.get(spRegisterTeacher.getSelectedItemPosition()));

                }else if(! edt_pass.getText().toString().equals(edt_conf_pass.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "لطفا رمز عبور را درست وارد کنید", Toast.LENGTH_SHORT).show();
                    edt_conf_pass.requestFocus();
                }else {
                    Toast.makeText(RegisterActivity.this, "لطفا ایمیل را درست وارد کنید", Toast.LENGTH_SHORT).show();
                    edt_email.requestFocus();
                }



                break;
            }
            default:
                break;
        }
    }

    private void register(final String fullname, final String email, String pass, String id_ostad) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", fullname);
        params.put("email", email);
        params.put("pass", pass);
        params.put("id_ostad", id_ostad);
        params.put("payeh", save.load(AppController.SAVE_USER_PAYEH, "-1"));

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, AppController.URL_SIGNUP, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject resp = response;
                //Log.d("TAG--------OK", resp.toString());

                try {
                    if(resp.getString("status").equals("200")){

                        save.save(AppController.SAVE_LOGIN, "1");
                        save.save(AppController.SAVE_USER_NAME, fullname);
                        save.save(AppController.SAVE_USER_ID, resp.getString("id"));

                        Toast.makeText(RegisterActivity.this, "ثبت نام انجام شد", Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegisterActivity.this, "در حال انتقال به درگاه پرداخت...", Toast.LENGTH_SHORT).show();
                        requestPayment(email);

                    }else if (resp.getString("status").equals("204")){
                        Toast.makeText(RegisterActivity.this, "کاربری با این ایمیل قبلا ثبت نام شده", Toast.LENGTH_SHORT).show();
                    }else if (resp.getString("status").equals("206")){
                        Toast.makeText(RegisterActivity.this, "خطا در سرور لطفا بعدا سعی کنید", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(RegisterActivity.this, "لطفا در زمان دیگری اقدام کنید", Toast.LENGTH_SHORT).show();

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        jsonObjReq.setShouldCache(false);
        //myRequestQueue.getCache().clear();
        AppController.getInstance().addToRequestQueue(jsonObjReq,"REGISTER_STUDENT");

    }

    private void updateActiveUser(String id_user) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("id_user", id_user);

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, AppController.URL_CHECK_PAYMENT, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject resp = response;
                //Log.d("TAG--------OK", resp.toString());

                try {
                    if(resp.getString("status").equals("200")){

                        startActivity(new Intent(RegisterActivity.this, DarsActivity.class));
                        finish();

                    }else {
                        Toast.makeText(RegisterActivity.this, "بعدا سعی کنید", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(RegisterActivity.this, "لطفا در زمان دیگری اقدام کنید", Toast.LENGTH_SHORT).show();

                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        jsonObjReq.setShouldCache(false);
        //myRequestQueue.getCache().clear();
        AppController.getInstance().addToRequestQueue(jsonObjReq,"CHECK_PAYMENT");

    }

    private void requestPayment(String email) {

        ZarinPal       purchase = ZarinPal.getPurchase(this);
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



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
