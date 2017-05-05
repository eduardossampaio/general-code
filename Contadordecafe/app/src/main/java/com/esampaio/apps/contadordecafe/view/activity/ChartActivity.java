package com.esampaio.apps.contadordecafe.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esampaio.apps.contadordecafe.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        LineChart chart = (LineChart) findViewById(R.id.chart);
        PieChart pieChart = (PieChart) findViewById(R.id.pie_chart);
        HorizontalBarChart horizontalBarChart = (HorizontalBarChart) findViewById(R.id.horizontal_bar_chart);

        List<Entry> entries = new ArrayList<Entry>();
        List<Entry> entries2 = new ArrayList<Entry>();
        for (int i =0; i< 10; i++) {
            entries.add(new Entry(i, i*11));
            entries2.add(new Entry(i, (int) (i*17.5)));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Coisa um");
        dataSet.setColor(Color.rgb(255,10,147));
        LineDataSet dataSet2 = new LineDataSet(entries2, "Coisa dois");
        LineData lineData = new LineData(dataSet);
        lineData.addDataSet(dataSet2);
        chart.setData(lineData);
        chart.invalidate();
        Description description = new Description();
        description.setText("Gráfico em linhas");
        chart.setDescription(description);

        List<PieEntry> pieDataEntries = new ArrayList<>();
        pieDataEntries.add(new PieEntry(3,"Segunda"));
        pieDataEntries.add(new PieEntry(2,"Terça"));
        pieDataEntries.add(new PieEntry(7,"Quarta"));
        pieDataEntries.add(new PieEntry(3,"Quinta"));
        pieDataEntries.add(new PieEntry(4,"Sexta"));
        pieDataEntries.add(new PieEntry(5,"Sábado"));
        pieDataEntries.add(new PieEntry(1,"Domingo"));

        PieDataSet pieDataSet = new PieDataSet(pieDataEntries,"Cafés na semana");
        int[] colors =new int[]{
                Color.rgb(0,100,150),
                Color.rgb(100,25,150),
                Color.BLACK,
                Color.BLUE,
                Color.RED,
                Color.GRAY,
                Color.GREEN
        };
        pieDataSet.setColors(colors);
        pieDataSet.setValueTextColor(Color.WHITE);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        Description descriptionPizza = new Description();
        descriptionPizza.setText("Gráfico em pizza");
        pieChart.setDescription(description);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,5));
        barEntries.add(new BarEntry(2,4));
        barEntries.add(new BarEntry(3,5));
        barEntries.add(new BarEntry(4,9));
        barEntries.add(new BarEntry(5,2));
        barEntries.add(new BarEntry(6,2));
        barEntries.add(new BarEntry(7,6));
        barEntries.add(new BarEntry(8,1));
        BarData barData = new BarData();
        BarDataSet barDataSet = new BarDataSet(barEntries, "Cafés no mês");
        barData.addDataSet(barDataSet);
        horizontalBarChart.setData(barData);

    }
}
