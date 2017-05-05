package com.esampaio.apps.contadordecafe.persistence;

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
    private CafeDAO cafeDAO;

    public RepositorioCafe(Activity activity){
        cafeDAO = new CafeDAO(activity);
    }

    public Integer getQtdCafeHj(){
        return getQtdCafeDia(new Date(System.currentTimeMillis()));
    }
    public void beberCafeHj(){
        cafeDAO.beberCafe();
    }

    public Integer getQtdCafeDia(Date date){
        return cafeDAO.getQtdCafesBebidos(date);
    }


}
