package com.modeling.aleksey.modelinglab1;

import android.content.Context;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;



/**
 * It helps to create graphics in GraphicsActivity
 */

public class MyGraphHelper {

    public static final DataPoint[] getDensitySeries(double minimalX, double maximalX, double mA, double mB){
        int weight = getDataPointsDensityWeight(minimalX, maximalX);
        int axisX = (int) minimalX;
        int i = 1;

        DataPoint[] dataPoints = new DataPoint[weight];

        dataPoints[0] = new DataPoint(minimalX,0);
        while(axisX < mA){
            axisX++;
            dataPoints[i] = new DataPoint(axisX,0);
            i++;
        }
        dataPoints[i] = new DataPoint(mA, 1/(mB-mA));
        i++;
        dataPoints[i] = new DataPoint(mB, 1/(mB-mA));
        i++;

        axisX = (int) mB;
        while (i < weight-1){
            dataPoints[i] = new DataPoint(axisX, 0);
            axisX++;
            i++;
        }
        dataPoints[weight-1] = new DataPoint(maximalX,0);

        return dataPoints;
    }

    public static final int getDataPointsDensityWeight(double minimalX, double maximalX){
        int weight = 0;

        try {
            weight = (int)(maximalX - minimalX + 2); //the number of points on axis (x,0) and + 2 points for a and b
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return weight;
    }

    public static final DataPoint[] getCumulativeDistributionSeries(double minimalX, double maximalX, double mA, double mB){
        DataPoint[] dataPoints = new DataPoint[4];
        dataPoints[0] = new DataPoint(minimalX, 0);
        dataPoints[1] = new DataPoint(mA,0);
        dataPoints[2] = new DataPoint(mB, 1);
        dataPoints[3] = new DataPoint(maximalX, 1);
        return dataPoints;
    }

    /*
    * For Normal Distribution graphic
    * */

    public static final double getErf(double x){
        double sum = x, mult = 1, memb, eps = 1e-20;
        int n = 0;

        do
        {
            n++;
            mult *= - x * x / n;
            memb = x / (2 * n + 1) * mult;
            sum += memb;
        } while ( Math.abs(memb) >= eps );

        return 2 / Math.sqrt(Math.PI) * sum;
    }




    public static final DataPoint[] getNormal1DistributionSeries(double minimalX, double maximalX, double mU, double mQ){
        int weight = (int)((maximalX-minimalX)/0.1);

        double currentPosition = minimalX;
        MathContext mathContext = new MathContext(15, RoundingMode.HALF_UP); // для double
        BigDecimal bigDecimal = new BigDecimal(currentPosition, mathContext);
        bigDecimal = bigDecimal.setScale(1, BigDecimal.ROUND_DOWN);
        currentPosition = bigDecimal.doubleValue(); //ostavlyaem 1 znak posle , v double

        int counter = 0;
        DataPoint[] dataPoints = new DataPoint[weight];
        while(counter < weight){
            dataPoints[counter] = new DataPoint(currentPosition,
                    ((1/(mQ*Math.sqrt(2*Math.PI)))
                            *(Math.exp(-((Math.pow((currentPosition-mU),2))/(2*Math.pow(mQ,2)))))));

            //Math.exp(-((Math.pow((currentPosition-mU),2))/(2*Math.pow(mQ,2))));
            //1/(mQ*Math.sqrt(2*Math.PI));

            currentPosition += 0.1;
            counter++;
        }

        return dataPoints;
    }

    public static final DataPoint[] getNormal2DistributionSeries(double minimalX, double maximalX, double mU, double mQ){
        int weight = (int)((maximalX-minimalX)/0.1);

        double currentPosition = minimalX;
        MathContext mathContext = new MathContext(15, RoundingMode.HALF_UP); // для double
        BigDecimal bigDecimal = new BigDecimal(currentPosition, mathContext);
        bigDecimal = bigDecimal.setScale(1, BigDecimal.ROUND_DOWN);
        currentPosition = bigDecimal.doubleValue(); //ostavlyaem 1 znak posle , v double

        int counter = 0;
        DataPoint[] dataPoints = new DataPoint[weight];
        while (counter < weight){
            dataPoints[counter] = new DataPoint(currentPosition,
                    0.5*(1+getErf(((currentPosition-mU)/(Math.sqrt(2*Math.pow(mQ,2)))))));

            //0.5*(1+getErf(((currentPosition-mU)/(Math.sqrt(2*Math.pow(mQ,2))))));

            currentPosition +=0.1;
            counter++;
        }
        return dataPoints;
    }

}
