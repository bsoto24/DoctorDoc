package com.doctordocplus.doctordoc.presenter.activity;

import android.app.SearchManager;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.CitaTO;
import com.doctordocplus.doctordoc.presenter.adapter.HistorialAdapter;

import java.util.ArrayList;
import java.util.List;

public class HistorialCitasActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView rvCategorias;
    private LinearLayoutManager llm;
    private HistorialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_citas);

        showToolbar("Historial de citas", true);

        rvCategorias = (RecyclerView) findViewById(R.id.rv_categorias);
        llm = new LinearLayoutManager(this);
        rvCategorias.setLayoutManager(llm);
        adapter = new HistorialAdapter(dataSet(), this);
        rvCategorias.setAdapter(adapter);

    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private ArrayList<CitaTO> dataSet() {
        ArrayList<CitaTO> citas = new ArrayList<>();
        citas.add(new CitaTO("Nº 001","29 MAY","5:00 PM","Dickson Espinoza","Resuelta"));
        citas.add(new CitaTO("Nº 002","30 MAY","10:00 AM","David Tacuchi","Resuelta"));
        citas.add(new CitaTO("Nº 003","01 MAY","6:00 PM","Alisson Cruz","Resuelta"));
        citas.add(new CitaTO("Nº 004","05 MAY","8:00 PM","Orestes Cachay","Tratamiento"));
        citas.add(new CitaTO("Nº 005","08 MAY","11:00 AM","Jorge Guerra","Tratamiento"));
        return citas;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(getBaseContext(), "SUBMIT", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        Log.e("TratamientoActivity", "onQueryTextChange: " + query);

        query = query.toLowerCase();

        final ArrayList<CitaTO> dataFiltrada = new ArrayList<>();
        for (CitaTO model : dataSet()) {
            final String text = model.getPaciente().toLowerCase();
            if (text.contains(query)) {
                dataFiltrada.add(model);
            }
        }
        if (dataFiltrada.size() > 0) {
            adapter.filter(dataFiltrada, query);
        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchitem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchitem);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        TextView searchText = (TextView)
                searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchText.setTextColor(Color.parseColor("#FFFFFF"));
        searchText.setHintTextColor(Color.parseColor("#FFFFFF"));
        searchText.setHint("Busca a un paciente");
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
