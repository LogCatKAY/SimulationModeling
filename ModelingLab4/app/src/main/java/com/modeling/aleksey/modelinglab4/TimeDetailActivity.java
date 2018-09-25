package com.modeling.aleksey.modelinglab4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

public class TimeDetailActivity extends AppCompatActivity {

    private ImageView mTimeBuf;
    private DetailImage mTimeDetailImage;

    public static Intent startTimeDetailActivity(Context packageContext){
        Intent intent = new Intent(packageContext, TimeDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTimeBuf = (ImageView) findViewById(R.id.iv_timeBuf);

        mTimeDetailImage = new DetailImage(getClass());

        mTimeBuf.setImageResource(mTimeDetailImage.getTimeBuf());
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
