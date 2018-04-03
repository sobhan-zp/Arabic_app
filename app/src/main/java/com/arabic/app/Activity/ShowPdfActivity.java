package com.arabic.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arabic.app.Network.AppController;
import com.arabic.app.Network.SavePref;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Class_Hashtom.tarjome_sazi_1.Tarmrin_8_class_1;
import com.arabic.app.Paye_Haft.Hashtom.Tamrin_Home_Hashtom.tarjome_sazi_1.Tarmrin_8_home_1;
import com.arabic.app.Paye_Haft.Nohom.Azmoon_9.A_1.Azmoon_9_1;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Class_Nohom.TrueFalse_1.Tarmrin_9_class_1;
import com.arabic.app.Paye_Haft.Nohom.Tamrin_Home_Nohom.tarjome_sazi_1.Tarmrin_9_home_1;
import com.arabic.app.R;
import com.crashlytics.android.Crashlytics;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;

import io.fabric.sdk.android.Fabric;

import static java.lang.String.format;

public class ShowPdfActivity extends AppCompatActivity implements OnPageChangeListener {

    PDFView pdfView;
    Integer pageNumber = 1;
    String pdfName = "";
    SavePref save;

    private Button btn_showpdf_testSchool, btn_showpdf_testhome, btn_showpdf_teacher, btn_showpdf_exam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdf);

        save = new SavePref(this);
        Fabric.with(this, new Crashlytics());

        findView();

        final Bundle ex = getIntent().getExtras();
        if (ex != null) {
            switch (ex.getString("file")) {
                case "7":
                    pdfName = AppController.DARS_P7_7.substring(AppController.DARS_P7_7.lastIndexOf('/') + 1, AppController.DARS_P7_7.length());
                    displayFromUri(new File
                            (Environment.getExternalStorageDirectory() + "/.arabi/" + pdfName));

                    break;
                case "8":
                    if (AppController.DOWNLOAD_FREE_8){
                        pdfName = AppController.DARS_P7_8.substring(AppController.DARS_P7_8.lastIndexOf('/') + 1, AppController.DARS_P7_8.length());
                        displayFromAsset("eight.pdf");

                    }else {
                        pdfName = AppController.DARS_P7_8.substring(AppController.DARS_P7_8.lastIndexOf('/') + 1, AppController.DARS_P7_8.length());
                        displayFromUri(new File
                                (Environment.getExternalStorageDirectory() + "/.arabi/" + pdfName));
                        AppController.DOWNLOAD_FREE_8 = false;
                    }

                    break;

                case "9":
                    pdfName = AppController.DARS_P7_9.substring(AppController.DARS_P7_9.lastIndexOf('/') + 1, AppController.DARS_P7_9.length());
                    displayFromUri(new File
                            (Environment.getExternalStorageDirectory() + "/.arabi/" + pdfName));
                    break;

                case "10":
                    pdfName = AppController.DARS_P7_10.substring(AppController.DARS_P7_10.lastIndexOf('/') + 1, AppController.DARS_P7_10.length());
                    displayFromUri(new File
                            (Environment.getExternalStorageDirectory() + "/.arabi/" + pdfName));
                    break;

                case "11":
                    pdfName = AppController.DARS_P7_11.substring(AppController.DARS_P7_11.lastIndexOf('/') + 1, AppController.DARS_P7_11.length());
                    displayFromUri(new File
                            (Environment.getExternalStorageDirectory() + "/.arabi/" + pdfName));
                    break;

                case "12":
                    pdfName = AppController.DARS_P7_12.substring(AppController.DARS_P7_12.lastIndexOf('/') + 1, AppController.DARS_P7_12.length());
                    displayFromUri(new File
                            (Environment.getExternalStorageDirectory() + "/.arabi/" + pdfName));
                    break;
            }
        } else finish();


        btn_showpdf_testSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = null;
                switch (ex.getString("file")) {
                    case "8":
                        intent = new Intent(getApplicationContext(), Tarmrin_8_class_1.class);
                        break;

                    case "9":
                        intent = new Intent(getApplicationContext(), Tarmrin_9_class_1.class);
                        break;
                }
                startActivity(intent);
            }
        });

        btn_showpdf_testhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (ex.getString("file")) {
                    case "8":
                        intent = new Intent(getApplicationContext(), Tarmrin_8_home_1.class);
                        break;

                    case "9":
                        intent = new Intent(getApplicationContext(), Tarmrin_9_home_1.class);
                        break;
                }
                startActivity(intent);

            }
        });

        btn_showpdf_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowPdfActivity.this, "بزودی ارتباط با استاد قرار میگیرد", Toast.LENGTH_SHORT).show();
            }
        });


        btn_showpdf_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(save.load(AppController.SAVE_AZMON_9, 0)==1){
                    Toast.makeText(ShowPdfActivity.this, "شما قبلا این آزمون را گذرانده اید", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(ShowPdfActivity.this, Azmoon_9_1.class));
                }
            }
        });

    }


    private void findView() {
        pdfView = (PDFView) findViewById(R.id.pdfview);
        btn_showpdf_testSchool = (Button) findViewById(R.id.btn_showpdf_testSchool);
        btn_showpdf_testhome = (Button) findViewById(R.id.btn_showpdf_testhome);
        btn_showpdf_teacher = (Button) findViewById(R.id.btn_showpdf_teacher);
        btn_showpdf_exam = (Button) findViewById(R.id.btn_showpdf_exam);
    }

    private void displayFromUri(File file) {
        pdfView.fromFile(file)
                .defaultPage(0)
                .onPageChange(this)
                .load();
    }

    private void displayFromAsset(String file) {
        pdfView.fromAsset(file)
                .defaultPage(0)
                .onPageChange(this)
                .load();

    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(format("%s %s / %s", pdfName, page, pageCount));
    }
}
