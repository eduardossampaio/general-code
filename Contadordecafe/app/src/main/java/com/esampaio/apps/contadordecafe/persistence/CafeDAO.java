package com.esampaio.apps.contadordecafe.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.esampaio.apps.contadordecafe.persistence.sqlite.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Eduardo on 03/05/2017.
 */

public class CafeDAO {
    private Context context;
    public CafeDAO(Context context){
        this.context = context;
    }
    public void beberCafe(){
        String insertSql = "insert into cafes_bebidos (data_hora) values (datetime('%s'));";
        insertSql = String.format(insertSql, format(new Date(System.currentTimeMillis())));
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        database.execSQL(insertSql);
        database.close();
    }

    public int getQtdCafesBebidos(Date date){
        int qtd = 0;
        String sql = "select count(*) from cafes_bebidos where date(data_hora) = date('%s');";
        sql = String.format(sql, format(date));
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do {
            qtd = cursor.getInt(0);
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return qtd;
    }

    private String format(Date date){
        String format = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
