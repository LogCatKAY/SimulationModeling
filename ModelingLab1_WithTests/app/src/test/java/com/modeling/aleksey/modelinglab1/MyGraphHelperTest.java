package com.modeling.aleksey.modelinglab1;

import android.content.Context;

import com.jjoe64.graphview.series.DataPoint;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;


import java.lang.reflect.Method;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by korchagin on 26.03.18.
 */
public class MyGraphHelperTest {

//    private Graphics2Activity graphics2Activity;
//
//
//    @Before
//    public void setUp() throws Exception {
//        MyGraphHelper mGraphHelper = mock(MyGraphHelper.class);
//    }



    @Test
    public void getDensitySeries() throws Exception {
        double minX = -5;
        double maxX = 5.5;
        double mA = 2;
        double mB = 4;
        final int seriesExpectedCount = 12;

        DataPoint[] dataPoints = new DataPoint[MyGraphHelper.getDataPointsDensityWeight(minX,maxX)];

        assertThat(dataPoints.length, is(seriesExpectedCount));

        dataPoints = MyGraphHelper.getDensitySeries(minX, maxX, mA, mB);

        assertThat(dataPoints[0].getX(), is(minX));
        assertThat(dataPoints[0].getY(), is(0.0));

        assertThat(dataPoints[7].getX(), is(mA));
        assertThat(dataPoints[7].getY(), is(0.0));

        assertThat(dataPoints[8].getX(), is(mA));
        assertThat(dataPoints[8].getY(), is(1/(mB-mA)));

        assertThat(dataPoints[9].getX(), is(mB));
        assertThat(dataPoints[9].getY(), is(1/(mB-mA)));

        assertThat(dataPoints[10].getX(), is(mB));
        assertThat(dataPoints[10].getY(), is(0.0));

        assertThat(dataPoints[11].getX(), is(maxX));
        assertThat(dataPoints[11].getY(), is(0.0));
    }

    @Test
    public void getDataPointsDensityWeight() throws Exception {
        assertThat(MyGraphHelper.getDataPointsDensityWeight(2, 10), is(10));
        assertThat(MyGraphHelper.getDataPointsDensityWeight(-5, 0), is(7));
        assertThat(MyGraphHelper.getDataPointsDensityWeight(-2.5, 0.4), is(4));
    }

    @Test
    public void getCumulativeDistributionSeries() throws Exception {
        final int seriesExpectedCount = 4;
        DataPoint[] dataPoints;
        dataPoints = MyGraphHelper
                .getCumulativeDistributionSeries(-5, 5, 2, 3);

        assertThat(dataPoints.length, is(seriesExpectedCount));

        assertThat(dataPoints[0].getX(), is(-5.0));
        assertThat(dataPoints[0].getY(), is(0.0));
        assertThat(dataPoints[1].getX(), is(2.0));
        assertThat(dataPoints[1].getY(), is(0.0));
        assertThat(dataPoints[2].getX(), is(3.0));
        assertThat(dataPoints[2].getY(), is(1.0));
        assertThat(dataPoints[3].getX(), is(5.0));
        assertThat(dataPoints[3].getY(), is(1.0));
    }

    @Test
    public void getErf() throws Exception {
        assertThat(0.5*(1+MyGraphHelper.getErf(-2.9155)), is(1.868714827385487E-5));
    }

    //0.5*(1+erf(-2.9155))
    //1,868714827385487E-5

    @Test
    public void getNormal1DistributionSeries() throws Exception {
        final int seriesExpectedCount = 70;
        double minX = -3.5;
        double maxX = 3.5;
        double mU = 0;
        double mQ = 1;
        DataPoint[] dataPoints = MyGraphHelper
                .getNormal1DistributionSeries(minX, maxX,mU , mQ);

        assertThat(dataPoints.length, is(seriesExpectedCount));

        int currentPosition = 0;
        double currentX = minX;
        while(currentPosition < dataPoints.length){
            assertThat(dataPoints[currentPosition].getX(), is(currentX));
            assertThat(dataPoints[currentPosition].getY(), is((1/(mQ*Math.sqrt(2*Math.PI)))
                    *(Math.exp(-((Math.pow((currentX-mU),2))/(2*Math.pow(mQ,2)))))));
            currentX += 0.1;
            currentPosition++;
        }

    }

    @Test
    public void getNormal2DistributionSeries() throws Exception {


        final int seriesExpectedCount = 70;
        double minX = -3.5;
        double maxX = 3.5;
        double mU = 0;
        double mQ = 1;
        DataPoint[] dataPoints = MyGraphHelper
                .getNormal2DistributionSeries(minX, maxX,mU , mQ);

        assertThat(dataPoints.length, is(seriesExpectedCount));

        int currentPosition = 0;
        double currentX = minX;

        while (currentPosition < dataPoints.length){
            assertThat(dataPoints[currentPosition].getX(), is(currentX));
            assertThat(dataPoints[currentPosition].getY(),
                    is(0.5*(1.0+MyGraphHelper.getErf(((currentX-mU)/(Math.sqrt(2.0*Math.pow(mQ,2.0))))))));
            currentX += 0.1;
            currentPosition++;
        }

    }

}