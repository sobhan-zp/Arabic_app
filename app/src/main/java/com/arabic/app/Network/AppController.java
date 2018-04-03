package com.arabic.app.Network;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Maziar on 11/16/2017.
 */

public class AppController  extends Application {

    public static final String TAG = AppController.class
            .getSimpleName();


    public final static String URL = "http://iava.in/arabi/app/index.php/api/";

    public final static String URL_LOGIN = URL + "auth/loginstudent";
    public final static String URL_SIGNUP = URL + "auth/signupstudent";
    public final static String URL_FORGETPASS = URL + "auth/forgotstudent";
    public final static String URL_AZMON_RESULT = URL + "student/addazmoon";

    public final static String URL_PAYMENT_PAY = URL + "payment/pay";
    public final static String URL_PAYMENT_VERIFY = URL + "payment/verify";
    public final static String URL_PAYMENT_CHECK = URL + "payment/check";

    public final static String URL_OSTAD= URL + "config/ostad";
    public final static String URL_CHECK_PAYMENT= URL + "config/checkpayment";


    public final static String SAVE_SCORE_AZMOON = "SAVE_SCORE_AZMOON";

    public final static String SAVE_RANK = "SAVE_RANK";
    public final static String SAVE_LOGIN = "SAVE_LOGIN";
    public final static String SAVE_CHECK_PAYMENT = "SAVE_CHECK_PAYMENT";

    public final static String SAVE_USER_ID = "SAVE_USER_ID";
    public final static String SAVE_USER_NAME = "SAVE_USER_NAME";
    public final static String SAVE_USER_PAYEH = "SAVE_USER_PAYEH";

    public final static String SAVE_AZMON_9 = "SAVE_AZMON_9";


    //public final static String PAY_MERCHENT_CODE = "97161756-7cb2-11e6-bfce-000c295eb8fc";
    public final static String PAY_MERCHENT_CODE = "41b7851c-7a70-11e7-bca1-000c295eb8fc";
    public final static int PAY_PRICE = 10000;

    public static boolean CLOSE_ACTIVITY = false;
    public static boolean DOWNLOAD_FREE_8 = false;



    public final static String DARS_P7_7 = "http://iava.in/arabi/dl/7/darsname-7.pdf";
    public final static String DARS_P7_8 = "http://iava.in/arabi/dl/7/darsname-8.pdf";
    public final static String DARS_P7_9 = "http://iava.in/arabi/dl/7/darsname-9.pdf";
    public final static String DARS_P7_10 = "http://iava.in/arabi/dl/7/darsname-10.pdf";
    public final static String DARS_P7_11 = "http://iava.in/arabi/dl/7/darsname-11.pdf";
    public final static String DARS_P7_12 = "http://iava.in/arabi/dl/7/darsname-12.pdf";
    //AppController.DARS_P7_8.substring(AppController.DARS_P7_8.lastIndexOf('/') + 1, AppController.DARS_P7_8.length())


    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }



}