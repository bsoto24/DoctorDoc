package com.doctordocplus.doctordoc.presenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.doctordocplus.doctordoc.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class CalificacionActivity extends AppCompatActivity {

    private PieChartView pieChart;
    private PieChartData data;
    private boolean hasLabels = false;
    private boolean hasLabelsOutside = false;
    private boolean hasLabelForSelected = false;
    private int buenas = 5, malas = 2, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        showToolbar("Calificacion", true);

        pieChart = (PieChartView) findViewById(R.id.chart);

        buenas = 1;
        malas = 8;
        total = buenas + malas;

        pieChart.setOnValueTouchListener(new ValueTouchListener());
        toggleLabels();
        generateData();
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

    private class ValueTouchListener implements PieChartOnValueSelectListener {

        @Override
        public void onValueSelected(int arcIndex, SliceValue value) {
            Toast.makeText(CalificacionActivity.this, value.getValue() + " %", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onValueDeselected() {

        }
    }

    private void toggleLabels() {
        hasLabels = !hasLabels;
        if (hasLabels) {
            hasLabelForSelected = false;
            pieChart.setValueSelectionEnabled(hasLabelForSelected);
            if (hasLabelsOutside) {
                pieChart.setCircleFillRatio(0.7f);
            } else {
                pieChart.setCircleFillRatio(1.0f);
            }
        }
        generateData();
    }

    /*Reinicia los valores de las variables*/
    public void resetCounts() {
        buenas = 0;
        malas = 0;
    }

    private void generateData() {
        int numValues = 2;    // Numero de particiones y/o variables
        List<SliceValue> values = new ArrayList<SliceValue>();
        /*Definimos el tamano (mediante un valor porcentual referente a cierta variable) y el color que tendra*/
        if (buenas > 0) {
            SliceValue sliceValueBuenas = new SliceValue((float) buenas * 100 / total, getResources().getColor(R.color.colorAccent));
            values.add(sliceValueBuenas);
        }
        if (malas > 0) {
            SliceValue sliceValueMalas = new SliceValue((float) malas * 100 / total, getResources().getColor(R.color.colorPrimary));
            values.add(sliceValueMalas);
        }
        data = new PieChartData(values);
        data.setHasLabels(hasLabels); // Muesta el valor de la particion
        pieChart.setPieChartData(data);
    }
}
