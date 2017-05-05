package com.esampaio.apps.contadordecafe.persistence.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.esampaio.apps.contadordecafe.R;


/**
 * Created by Eduardo on 03/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String name = "cafe_db";
    private static final Integer version =1;
    private Context context;
    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSql = context.getResources().getString(R.string.create_db_sql);
        db.execSQL(createSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
