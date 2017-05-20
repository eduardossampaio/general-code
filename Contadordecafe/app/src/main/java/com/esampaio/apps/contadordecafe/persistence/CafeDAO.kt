package com.esampaio.apps.contadordecafe.persistence

import android.content.Context
import com.esampaio.apps.contadordecafe.persistence.sqlite.DatabaseHelper
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Eduardo on 03/05/2017.
 */

class CafeDAO(private val context: Context) {
    fun beberCafe() {
        var dateFormatted  = format(Date(System.currentTimeMillis()));
        var insertSql = "insert into cafes_bebidos (data_hora) values (datetime('${dateFormatted}'));"
        val databaseHelper = DatabaseHelper(context)
        val database = databaseHelper.readableDatabase
        database.execSQL(insertSql)
        database.close()
    }

    fun getQtdCafesBebidos(date: Date): Int {
        var sql = "select count(*) from cafes_bebidos where date(data_hora) = date('${format(date)}');"
        return executeQuery(sql);
    }
    fun getQtdCafesBebidos(initDate: Date,finalDate:Date): Int {
        var sql = "select count(*) from cafes_bebidos where  datetime(data_hora) between datetime('${format(initDate)}') and datetime('${format(finalDate)}')"
        return executeQuery(sql);
    }
    private fun executeQuery(sql:String) :Int{
        var qtd=0
        val databaseHelper = DatabaseHelper(context)
        val db = databaseHelper.readableDatabase
        val cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()
        do {
            qtd = cursor.getInt(0)
        } while (cursor.moveToNext())
        cursor.close()
        db.close()
        return qtd
    }
     fun format(date: Date): String {
        val format = "yyyy-MM-dd HH:mm:ss"
        val simpleDateFormat = SimpleDateFormat(format)
        return simpleDateFormat.format(date)
    }
}
