package com.doctordocplus.doctordoc.presenter.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.CitaTO;
import com.doctordocplus.doctordoc.presenter.adapter.CitaAdapter;

import java.util.ArrayList;
import java.util.List;

public class CitasActivity extends AppCompatActivity {

    private RecyclerView rvCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        showToolbar("Citas Programadas", true);

        rvCitas = (RecyclerView) findViewById(R.id.rv_citas_programadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvCitas.setLayoutManager(llm);
        CitaAdapter adapter = new CitaAdapter(dataSet(), this);
        rvCitas.setAdapter(adapter);

    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private List<CitaTO> dataSet() {
        List<CitaTO> citas = new ArrayList<>();
        citas.add(new CitaTO("Nº 001","29 MAY","5:00 PM","Dickson Espinoza","Consulta General"));
        citas.add(new CitaTO("Nº 002","30 MAY","10:00 AM","David Tacuchi","Consulta General"));
        citas.add(new CitaTO("Nº 003","01 MAY","6:00 PM","Alisson Cruz","Consulta General"));
        citas.add(new CitaTO("Nº 004","05 MAY","8:00 PM","Orestes Cachay","Consulta General"));
        citas.add(new CitaTO("Nº 005","08 MAY","11:00 AM","Jorge Guerra","Consulta General"));
        return citas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_calendar){
            Intent intent = new Intent(CitasActivity.this, CalendarActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return super.onOptionsItemSelected(item);
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
}
