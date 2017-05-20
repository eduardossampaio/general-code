package com.esampaio.apps.contadordecafe.view.estatistica.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.esampaio.apps.contadordecafe.R
import com.esampaio.apps.contadordecafe.view.estatistica.fragment.FragmentGraficos
import com.esampaio.apps.contadordecafe.view.estatistica.fragment.GraficosDiarioFragment

class ChartActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estatisticas_activity)
        tabLayout = findViewById(R.id.tablayout) as TabLayout
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setContent(tab.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        setContent(0);
    }

    private fun setContent(tabSelected: Int) {
        var fragmentGraficos:FragmentGraficos;
        if(tabSelected==0){
            fragmentGraficos = GraficosDiarioFragment.newInstance()
        }else {
           fragmentGraficos = FragmentGraficos.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentGraficos).commit()
    }
}
