package com.esampaio.apps.contadordecafe;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eduardo on 20/03/17.
 */

public class RepositorioCafe {
    private Activity activity;
    private static final String SHARED_PREFERENCES_NAME = "QUERO_CAFE";
    public RepositorioCafe(Activity activity){
        this.activity = activity;
    }
    public Integer getQtdCafeHj(){
        return getQtdCafeDia(new Date(System.currentTimeMillis()));
    }
    public void beberCafeHj(){
        beberCafe(new Date(System.currentTimeMillis()));
    }
    public void beberCafe(Date date){
        int qtdBebida = getQtdCafeDia(date);
        qtdBebida++;
        salvar(date,qtdBebida);
    }
    public Integer getQtdCafeDia(Date date){
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        int qtdTomada = sharedPreferences.getInt(format(date), 0);
        return qtdTomada;
    }

    private String format(Date date){
        String format = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
    private void salvar(Date date,Integer qtd){
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(format(date),qtd).commit();
    }
}
