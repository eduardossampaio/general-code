package com.esampaio.apps.contadordecafe.view.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.esampaio.apps.contadordecafe.view.adapter.ListCafeAdapter;
import com.esampaio.apps.contadordecafe.R;
import com.esampaio.apps.contadordecafe.persistence.RepositorioCafe;
import com.esampaio.apps.contadordecafe.view.estatistica.activity.ChartActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView btBeberCafe;
    private TextView txtQtdCafeBebido;
    private TextView titulo;
    private TextView subtitulo;
    private RepositorioCafe repositorioCafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repositorioCafe = new RepositorioCafe(this);
        btBeberCafe = (ImageView) findViewById(R.id.bt_beber_cafe);
        txtQtdCafeBebido = (TextView) findViewById(R.id.txt_qtd_cafe_hoje);
        subtitulo = (TextView) findViewById(R.id.subtitulo);
        btBeberCafe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btBeberCafe.setRotation(-45);
                        break;
                    case MotionEvent.ACTION_UP:
                        btBeberCafe.setRotation(0);
                        beberCafe();
                }
                return true;
            }
        });
        loadCafesBebidos();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(getString(R.string.toolbar_name));
        }
    }

    private void loadCafesBebidos() {
        Integer qtdCafesBebidosHj = repositorioCafe.getQtdCafeHj();
        if(qtdCafesBebidosHj <= 1){
            subtitulo.setText("Café hoje");
        }else{
            subtitulo.setText("Cafés hoje");
        }
        txtQtdCafeBebido.setText(String.valueOf(qtdCafesBebidosHj));
    }
    private void beberCafe(){
        repositorioCafe.beberCafeHj();
        loadCafesBebidos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_graficos){
            Intent intent = new Intent(MainActivity.this,ChartActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
