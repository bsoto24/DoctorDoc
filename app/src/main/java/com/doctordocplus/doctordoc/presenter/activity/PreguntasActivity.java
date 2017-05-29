package com.doctordocplus.doctordoc.presenter.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.PreguntaTO;
import com.doctordocplus.doctordoc.presenter.adapter.PreguntasAdapter;

import java.util.ArrayList;

public class PreguntasActivity extends AppCompatActivity {
    private RecyclerView rvPreguntas;
    private LinearLayoutManager llm;
    private PreguntasAdapter adapter;
    private FloatingActionButton btnMore;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Preguntas Frecuentes");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        btnMore = (FloatingActionButton) findViewById(R.id.btn_more);
        rvPreguntas = (RecyclerView) findViewById(R.id.rv_preguntas);
        llm = new LinearLayoutManager(this);
        rvPreguntas.setLayoutManager(llm);
        adapter = new PreguntasAdapter(getData(), this);
        rvPreguntas.setAdapter(adapter);

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPregunta();
            }
        });

    }

    private void dialogPregunta() {
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = this.getLayoutInflater();
//        View dialogView = inflater.inflate(R.layout.dialog_pregunta, null);
//        Button btnSend = (Button) dialogView.findViewById(R.id.btn_enviar);
//        dialogBuilder.setView(dialogView);
//        final AlertDialog alertDialog = dialogBuilder.create();
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertDialog.dismiss();
//            }
//        });
//        alertDialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private ArrayList<PreguntaTO> getData() {

        ArrayList<PreguntaTO> preguntas = new ArrayList<>();
        preguntas.add(new PreguntaTO("1. Quien puede ver mi informacion?", "Su informacion es totalmente privada pero si usted desea puede hacerla publica para usarla como datos estadisticos"));
        preguntas.add(new PreguntaTO("2. Puedo generar mas de 1 cupon a la vez?", "Solo puedes generar un cupon, luego de consumirlo nuevamente podras generar otros"));
        preguntas.add(new PreguntaTO("3. Quien puede ver mi informacion?", "Su informacion es totalmente privada pero si usted desea puede hacerla publica para usarla como datos estadisticos"));
        preguntas.add(new PreguntaTO("4. Puedo generar mas de 1 cupon a la vez?", "Solo puedes generar un cupon, luego de consumirlo nuevamente podras generar otros"));
        preguntas.add(new PreguntaTO("5. Quien puede ver mi informacion?", "Su informacion es totalmente privada pero si usted desea puede hacerla publica para usarla como datos estadisticos"));
        preguntas.add(new PreguntaTO("6. Puedo generar mas de 1 cupon a la vez?", "Solo puedes generar un cupon, luego de consumirlo nuevamente podras generar otros"));

        return preguntas;
    }
}
