package com.doctordocplus.doctordoc.presenter.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.CitaTO;
import com.doctordocplus.doctordoc.presenter.adapter.CitaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rvCitas;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToolbar("DOCTOR DOC +", false);

        rvCitas = (RecyclerView) findViewById(R.id.rv_citas_programadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvCitas.setLayoutManager(llm);
        CitaAdapter adapter = new CitaAdapter(dataSet(), this);
        rvCitas.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private List<CitaTO> dataSet() {
        List<CitaTO> citas = new ArrayList<>();
        citas.add(new CitaTO("001","29 MAY","5:00 PM","Dickson Espinoza","Consulta General"));
        citas.add(new CitaTO("002","30 MAY","10:00 AM","David Tacuchi","Consulta General"));
        citas.add(new CitaTO("003","01 MAY","6:00 PM","Alisson Cruz","Consulta General"));
        citas.add(new CitaTO("004","05 MAY","8:00 PM","Orestes Cachay","Consulta Especializada"));
        citas.add(new CitaTO("005","08 MAY","11:00 AM","Jorge Guerra","Consulta General"));
        return citas;
    }

    public void showToolbar(String title, boolean upButton){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
