package com.esampaio.apps.contadordecafe.persistence.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import com.esampaio.apps.contadordecafe.R

/**
 * Created by Eduardo on 03/05/2017.
 */
class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, DatabaseHelper.name, null, DatabaseHelper.version) {

    override fun onCreate(db: SQLiteDatabase) {
        val createSql = context.resources.getString(R.string.create_db_sql)
        db.execSQL(createSql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        private val name = "cafe_db"
        private val version = 1
    }
}
