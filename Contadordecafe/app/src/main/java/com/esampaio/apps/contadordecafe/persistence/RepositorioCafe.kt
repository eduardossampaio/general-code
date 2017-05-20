package com.esampaio.apps.contadordecafe.persistence

import android.content.Context
import java.util.Date

/**
 * Created by eduardo on 20/03/17.
 */

class RepositorioCafe(context: Context) {
    private val cafeDAO: CafeDAO

    init {
        cafeDAO = CafeDAO(context)
    }

    val qtdCafeHj: Int
        get() = getQtdCafeDia(Date(System.currentTimeMillis()))

    fun beberCafeHj() {
        cafeDAO.beberCafe()
    }

    fun getQtdCafeDia(date: Date): Int {
        return cafeDAO.getQtdCafesBebidos(date)
    }

    fun getQtdCafeDia(initDate: Date,finalDate:Date): Int {
        return cafeDAO.getQtdCafesBebidos(initDate,finalDate);
    }
}
