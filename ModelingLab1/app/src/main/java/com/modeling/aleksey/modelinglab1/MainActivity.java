package com.modeling.aleksey.modelinglab1;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.GraphView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgGraph;
    private RadioButton radioUniform;
    private RadioButton radioNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            UniformDistributionFragment uniformFragment = new UniformDistributionFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container_graph, uniformFragment).commit();
        }

        rgGraph = (RadioGroup) findViewById(R.id.rgGraph);
        radioUniform = (RadioButton) findViewById(R.id.radioUniform);
        radioNormal = (RadioButton) findViewById(R.id.radioNormal);

        rgGraph.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case -1:
                        Toast.makeText(MainActivity.this, "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioUniform:
                        UniformDistributionFragment uniformDistributionFragment =
                                new UniformDistributionFragment();
                        replaceFragment(uniformDistributionFragment);
                        break;
                    case R.id.radioNormal:
                        NormalDistributionFragment normalDistributionFragment =
                                new NormalDistributionFragment();
                        replaceFragment(normalDistributionFragment);
                        break;
                }
            }
        });



    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_graph, fragment)
                //.addToBackStack(null)
                .commit();
    }

}

