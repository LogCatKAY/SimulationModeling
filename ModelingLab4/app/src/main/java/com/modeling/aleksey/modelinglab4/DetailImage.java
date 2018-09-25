package com.modeling.aleksey.modelinglab4;

import android.content.Context;

/**
 * Created by korchagin on 18.04.18.
 */

public class DetailImage {

    private int mEventBuf;
    private int mEventFuture;
    private int mTimeBuf;

    public int getEventBuf() {
        return mEventBuf;
    }

    public int getEventFuture() {
        return mEventFuture;
    }

    public int getTimeBuf() {
        return mTimeBuf;
    }

    private int event1[] = new int[]{
            R.drawable.ev_1_1,
            R.drawable.ev_1_2,
            R.drawable.ev_1_3,
            R.drawable.ev_1_4,
            R.drawable.ev_1_5
    };

    private int event2[] = new int[]{
            R.drawable.ev_2_1,
            R.drawable.ev_2_2,
            R.drawable.ev_2_3,
            R.drawable.ev_2_4,
            R.drawable.ev_2_5
    };

    private int time[] = new int[]{
            R.drawable.t_1_1,
            R.drawable.t_1_2,
            R.drawable.t_1_3,
            R.drawable.t_1_4,
            R.drawable.t_1_5
    };

    DetailImage(Class packageClass){

        if (packageClass.equals(EventDetailActivity.class)){
            int counter = (int)(Math.random() * 4);
            mEventBuf = event1[counter];
            mEventFuture = event2[counter];
        }
        if (packageClass.equals(TimeDetailActivity.class)){
            mTimeBuf = time[(int)(Math.random() * 4)];
        }

    }

}
