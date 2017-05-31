package com.doctordocplus.doctordoc.presenter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.doctordocplus.doctordoc.R;
import com.github.irvingryan.VerifyCodeView;

public class ActivacionActivity extends AppCompatActivity {

    private VerifyCodeView vcActivacion;
    private LinearLayout lyContent;
    private Toolbar toolbar;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activacion);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        lyContent = (LinearLayout) findViewById(R.id.ly_content);
        vcActivacion = (VerifyCodeView) findViewById(R.id.vc_activacion);
        btnContinuar = (Button) findViewById(R.id.btn_continuar);

        showToolbar("Activación", true);
        getSupportActionBar().setElevation(0);

        vcActivacion.setListener(new VerifyCodeView.OnTextChangListener() {
            @Override
            public void afterTextChanged(String text) {
                if (text.equals("12345")){
                    lyContent.setVisibility(View.VISIBLE);
                    vcActivacion.setEnabled(false);
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivacionActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
