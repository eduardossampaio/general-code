package com.esampaio.apps.contadordecafe.view.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.esampaio.apps.contadordecafe.view.adapter.ListCafeAdapter;
import com.esampaio.apps.contadordecafe.R;
import com.esampaio.apps.contadordecafe.persistence.RepositorioCafe;

public class MainActivity extends AppCompatActivity {

    private ImageView btBeberCafe;
    private TextView txtQtdCafeBebido;
    private RecyclerView listCafes;
    private RepositorioCafe repositorioCafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repositorioCafe = new RepositorioCafe(this);
        btBeberCafe = (ImageView) findViewById(R.id.bt_beber_cafe);
        txtQtdCafeBebido = (TextView) findViewById(R.id.txt_qtd_cafe_hoje);
        listCafes = (RecyclerView) findViewById(R.id.list_cafe);
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
        listCafes.setAdapter(new ListCafeAdapter(this));
        listCafes.setLayoutManager(new GridLayoutManager(this,6));
        loadCafesBebidos();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(getString(R.string.toolbar_name));
        }
    }

    private void loadCafesBebidos() {
        String txt = "Quantidade de cafés bebidos hoje: ";
        Integer qtdCafesBebidosHj = repositorioCafe.getQtdCafeHj();
        txt+=qtdCafesBebidosHj;
        txtQtdCafeBebido.setText(txt);
        ((ListCafeAdapter)listCafes.getAdapter()).setQtdCafes(qtdCafesBebidosHj);
    }
    private void beberCafe(){
        repositorioCafe.beberCafeHj();
        loadCafesBebidos();
    }
}
