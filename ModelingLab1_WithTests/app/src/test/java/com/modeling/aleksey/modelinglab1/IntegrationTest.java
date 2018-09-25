package com.modeling.aleksey.modelinglab1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowToast;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by korchagin on 26.03.18.
 */
//@Config(sdk = 19, constants = BuildConfig.class)
@RunWith(RobolectricTestRunner.class)
public class IntegrationTest {

    private MainActivity mainActivity;
    private UniformDistributionFragment uniformFragment;
    private View view;
    private Button btnBuildUniformGraph;
    private RadioButton radioUniform;

    @Before
    public void setUp(){
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        //mainActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();
        uniformFragment = (UniformDistributionFragment) mainActivity.getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_graph);
        view = uniformFragment.onCreateView(LayoutInflater.from(mainActivity),
                (ViewGroup) mainActivity.findViewById(R.id.fragment_container_graph),
                null);
        btnBuildUniformGraph = (Button) view.findViewById(R.id.btnBuildGraph);
    }

    @Test
    public void checkActivityIsNotNull() throws Exception{
        assertNotNull(mainActivity);
    }

    @Test
    public void checkUniformFragmentIsVisibleByDefault() throws Exception {
        assertThat(uniformFragment.isVisible(), is(true));
    }

    @Test
    public void isMainActivity() throws Exception{
        assertThat(mainActivity.getLocalClassName(), is("MainActivity"));
    }

    @Test
    public void defaultCheckedRadioButton_ShouldBeRadioUniform() throws Exception {
        radioUniform = (RadioButton) mainActivity.findViewById(R.id.radioUniform);
        assertThat(radioUniform.isChecked(), is(true));
    }

    @Test
    public void clickingEmptyBuildButton_shouldShowErrorToast() throws Exception {
        btnBuildUniformGraph.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), is("Повторите ввод"));
    }

    @Test
    public void Negative_clickingEmptyBuildButton_shouldShowErrorToast() throws Exception {
        btnBuildUniformGraph.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), is("Другая строка"));
    }

    @Test
    public void clickingBuildButtonWithParameters_ShouldOpenGraphicsActivity() throws Exception {
        EditText etMinX = (EditText) view.findViewById(R.id.etMinX);
        EditText etMaxX = (EditText) view.findViewById(R.id.etMaxX);
        EditText etA = (EditText) view.findViewById(R.id.etA);
        EditText etB = (EditText) view.findViewById(R.id.etB);

        etMinX.setText("1");
        etMaxX.setText("7");
        etA.setText("3");
        etB.setText("5");

        btnBuildUniformGraph.performClick();

        Intent expextedIntent = new Intent(mainActivity, GraphicsActivity.class);
        ShadowActivity nextActivity = Shadows.shadowOf(mainActivity);
        Intent actualIntent = nextActivity.getNextStartedActivity();

        assertTrue(actualIntent.filterEquals(expextedIntent));
//        ShadowIntent shadowIntent = Shadows.shadowOf(actualIntent);
//        assertEquals(GraphicsActivity.class.getName(), shadowIntent.getIntentClass().getName());
    }
}