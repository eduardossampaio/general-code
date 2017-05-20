package com.esampaio.apps.contadordecafe.view.estatistica.fragment

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.esampaio.apps.contadordecafe.persistence.RepositorioCafe
import com.esampaio.apps.contadordecafe.util.DateUtil
import java.util.*

/**
 * Created by Eduardo on 19/05/2017.
 */

class GraficosDiarioFragment: FragmentGraficos(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view:View? = super.onCreateView(inflater, container, savedInstanceState)
        return view;
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var hoje = Date(System.currentTimeMillis());
        var repCafe = RepositorioCafe(this.context);

        var qtdMadrugada = repCafe.getQtdCafeDia(DateUtil.setDateAndTime(hoje,0,0),DateUtil.setDateAndTime(hoje,6,0))
        var qtdManha = repCafe.getQtdCafeDia(DateUtil.setDateAndTime(hoje,6,0),DateUtil.setDateAndTime(hoje,12,0))
        var qtdTarde = repCafe.getQtdCafeDia(DateUtil.setDateAndTime(hoje,12,0),DateUtil.setDateAndTime(hoje,18,0))
        var qtdNoite = repCafe.getQtdCafeDia(DateUtil.setDateAndTime(hoje,18,0),DateUtil.setDateAndTime(hoje,0,0))

        var cafesDuranteDia:ArrayList<Pair<Float,String>> = ArrayList();
        cafesDuranteDia.add(Pair(qtdMadrugada.toFloat(),"Madrugada"))
        cafesDuranteDia.add(Pair(qtdManha.toFloat(),"Manhã"))
        cafesDuranteDia.add(Pair(qtdTarde.toFloat(),"Tarde"))
        cafesDuranteDia.add(Pair(qtdNoite.toFloat(),"Noite"))
        createPieChart(cafesDuranteDia,"Cafés ao longo do dia")

    }

    companion object {

        fun newInstance(): FragmentGraficos {
            val args = Bundle()
            val fragment = GraficosDiarioFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
