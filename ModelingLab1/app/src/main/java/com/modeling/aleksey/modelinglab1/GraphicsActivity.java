package com.modeling.aleksey.modelinglab1;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphicsActivity extends AppCompatActivity{

    private double minX;
    private double maxX;
    private double a;
    private double b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        minX = intent.getDoubleExtra("minX", 0);
        maxX = intent.getDoubleExtra("maxX", 0);
        a = intent.getDoubleExtra("a", 0);
        b = intent.getDoubleExtra("b", 0);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        GridLabelRenderer gridLabelRenderer = graph.getGridLabelRenderer();
        gridLabelRenderer.setHorizontalAxisTitle("x");
        gridLabelRenderer.setVerticalAxisTitle("F(x)");
        graph.setTitle("Плотность вероятности");

        Viewport viewport = graph.getViewport();
        viewport.setXAxisBoundsManual(true);
        //viewport.setYAxisBoundsManual(true);
        viewport.setScrollableY(true);
        //viewport.setScalableY(true);
        viewport.setScrollable(true);
        viewport.setScalable(true);
        //viewport.setMinY(-(1/(b-a)-1));
        viewport.setMaxY((1/(b-a))+5);
        viewport.setMinX(minX-1);
        viewport.setMaxX(maxX+1);


        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        GridLabelRenderer gridLabelRenderer2 = graph2.getGridLabelRenderer();
        gridLabelRenderer2.setHorizontalAxisTitle("x");
        gridLabelRenderer2.setVerticalAxisTitle("F(x)");
        graph2.setTitle("Функция распределения");

        Viewport viewport2 = graph2.getViewport();
        viewport2.setXAxisBoundsManual(true);
        //viewport2.setYAxisBoundsManual(true);
        viewport2.setScrollableY(true);
        //viewport2.setScalableY(true);
        viewport2.setScrollable(true);
        viewport2.setScalable(true);
        //viewport2.setMinY(-(1/(b-a)-1));
        viewport2.setMaxY((1/(b-a))+5);
        viewport2.setMinX(minX-1);
        viewport2.setMaxX(maxX+1);



        DataPoint[] dataDensity;
        dataDensity = MyGraphHelper.getDensitySeries(minX,maxX,a,b);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataDensity);
        series.setDrawBackground(true);
        series.setThickness(8);

        DataPoint[] dataCumulativeDistribution;
        dataCumulativeDistribution = MyGraphHelper.getCumulativeDistributionSeries(minX,maxX,a,b);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(dataCumulativeDistribution);
        series2.setColor(Color.RED);

        graph.addSeries(series);
        graph2.addSeries(series2);


    }

//    public int getDataPointsDensityWeight(){
//        int weight = 0;
//
//        try {
//            weight = (int)(maxX - minX + 2); //the number of points on axis (x,0) and + 2 points for a and b
//        }
//        catch (Exception ex){
//            Toast.makeText(
//                    GraphicsActivity.this,
//                    "Не смог вычислить вес массива",
//                    Toast.LENGTH_SHORT)
//                    .show();
//        }
//
//        return weight;
//    }
//
//    public DataPoint[] getDensitySeries(double minimalX, double maximalX, double mA, double mB){
//        int weight = getDataPointsDensityWeight();
//        int axisX = (int) minimalX;
//        int i = 1;
//
//        DataPoint[] dataPoints = new DataPoint[weight];
//
//        dataPoints[0] = new DataPoint(minimalX,0);
//        while(axisX < a){
//            axisX++;
//            dataPoints[i] = new DataPoint(axisX,0);
//            i++;
//        }
//        dataPoints[i] = new DataPoint(mA, 1/(mB-mA));
//        i++;
//        dataPoints[i] = new DataPoint(mB, 1/(mB-mA));
//        i++;
//
//        axisX = (int) mB;
//        while (i < weight-1){
//            dataPoints[i] = new DataPoint(axisX, 0);
//            axisX++;
//            i++;
//        }
//        dataPoints[weight-1] = new DataPoint(maximalX,0);
//
//        return dataPoints;
//    }
//
//    public DataPoint[] getCumulativeDistributionSeries(double minimalX, double maximalX, double mA, double mB){
//        DataPoint[] dataPoints = new DataPoint[4];
//        dataPoints[0] = new DataPoint(minimalX, 0);
//        dataPoints[1] = new DataPoint(mA,0);
//        dataPoints[2] = new DataPoint(b, 1);
//        dataPoints[3] = new DataPoint(maximalX, 1);
//        return dataPoints;
//    }

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
