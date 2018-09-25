package com.modeling.aleksey.modelinglab1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Graphics2Activity extends AppCompatActivity {

    public static final String MIN_X = "normMinX";
    public static final String MAX_X = "normMaxX";
    public static final String U = "u";
    public static final String Q = "q";

    private double minX;
    private double maxX;
    private double u;
    private double q;

    public void initNormGraph(GraphView graphView){
        GridLabelRenderer gridLabelRenderer = graphView.getGridLabelRenderer();
        gridLabelRenderer.setHorizontalAxisTitle("x");
        gridLabelRenderer.setVerticalAxisTitle("F(x)");
        graphView.setTitle("Нормальное распределение");

        Viewport viewport = graphView.getViewport();
        viewport.setXAxisBoundsManual(true);
        viewport.setYAxisBoundsManual(true);
        viewport.setScrollable(true);
        viewport.setMinY(0);
        viewport.setMaxY(1);
        viewport.setScalable(true);

        DataPoint[] dataPoints1;
        dataPoints1 = MyGraphHelper.getNormal1DistributionSeries(minX,maxX,u,q);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints1);
        series.setTitle("Плотность вероятности");

        DataPoint[] dataPoints2;
        dataPoints2 = MyGraphHelper.getNormal2DistributionSeries(minX,maxX,u,q);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(dataPoints2);
        series2.setTitle("Функция распределения");
        series2.setColor(Color.RED);

        graphView.addSeries(series);
        graphView.addSeries(series2);

        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        minX = intent.getDoubleExtra(MIN_X, 0);
        maxX = intent.getDoubleExtra(MAX_X, 0);
        u = intent.getDoubleExtra(U, 0);
        q = intent.getDoubleExtra(Q, 0);

        GraphView normGraph = (GraphView) findViewById(R.id.normGraph);
        initNormGraph(normGraph);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
