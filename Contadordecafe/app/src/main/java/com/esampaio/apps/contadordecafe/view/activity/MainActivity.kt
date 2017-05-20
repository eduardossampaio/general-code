package com.esampaio.apps.contadordecafe.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import com.esampaio.apps.contadordecafe.R
import com.esampaio.apps.contadordecafe.persistence.RepositorioCafe
import com.esampaio.apps.contadordecafe.view.estatistica.activity.ChartActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var repositorioCafe: RepositorioCafe? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repositorioCafe = RepositorioCafe(this)

        bt_beber_cafe.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> bt_beber_cafe!!.rotation = -45f
                MotionEvent.ACTION_UP -> {
                    bt_beber_cafe!!.rotation = 0f
                    beberCafe()
                }
            }
            true
        }
        loadCafesBebidos()
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = getString(R.string.toolbar_name)
        }
    }

    private fun loadCafesBebidos() {
        val qtdCafesBebidosHj = repositorioCafe?.qtdCafeHj
        if (qtdCafesBebidosHj!! <= 1) {
            subtitulo.text = "Café hoje"
        } else {
            subtitulo.text = "Cafés hoje"
        }
        txt_qtd_cafe_hoje!!.text = qtdCafesBebidosHj.toString()
    }

    private fun beberCafe() {
        repositorioCafe?.beberCafeHj()
        loadCafesBebidos()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_graficos) {
            val intent = Intent(this@MainActivity, ChartActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
