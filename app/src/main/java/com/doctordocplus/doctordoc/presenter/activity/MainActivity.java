package com.doctordocplus.doctordoc.presenter.activity;

import android.content.Intent;
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

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToolbar("DOCTOR DOC +", false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void showToolbar(String title, boolean upButton) {
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
        Intent intent = null;
        boolean flag = false;

        switch (id) {
            case R.id.nav_citas_programadas:
                intent = new Intent(MainActivity.this, CitasActivity.class);
                flag = true;
                break;
            case R.id.nav_historial_citas:
                intent = new Intent(MainActivity.this, HistorialCitasActivity.class);
                flag = true;
                break;
            case R.id.nav_preguntas:
                intent = new Intent(MainActivity.this, PreguntasActivity.class);
                flag = true;
                break;
            case R.id.nav_configurar:
                intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
                flag = true;
                break;
            case R.id.nav_calificacion:
                intent = new Intent(MainActivity.this, CalificacionActivity.class);
                flag = true;
                break;
            case R.id.nav_acerca_de:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                flag = true;
                break;

            case R.id.nav_salir:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                flag = true;
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if(flag){
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        return false;
    }
}

