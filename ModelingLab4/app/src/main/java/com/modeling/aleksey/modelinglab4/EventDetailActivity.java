package com.modeling.aleksey.modelinglab4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

public class EventDetailActivity extends AppCompatActivity {

    private static String EVENT_DETAIL_ACTIVITY = "EventDetailActivity";

    private ImageView mEventBuf;
    private  ImageView mEventFuture;
    private DetailImage mEventDetailImage;

    public static Intent startEventDetailActivity(Context packageContext){
        Intent intent = new Intent(packageContext, EventDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        mEventBuf = (ImageView) findViewById(R.id.iv_eventBuf);
        mEventFuture = (ImageView) findViewById(R.id.iv_eventFuture);

        mEventDetailImage = new DetailImage(getClass());

        mEventBuf.setImageResource(mEventDetailImage.getEventBuf());
        mEventFuture.setImageResource(mEventDetailImage.getEventFuture());

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
