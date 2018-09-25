package com.modeling.aleksey.modelinglab1;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UiAutomatorInstrumentedTest {

    private UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
    private static final String PACKAGE_NAME = "com.modeling.aleksey.modelinglab1";

    @Before
    public void openApp() throws Exception {
        Context context = getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), 5000);
    }

    @Test
    public void buildNormalGraph() throws UiObjectNotFoundException {
        UiObject mRadioNormal = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/radioNormal"));
        mRadioNormal.clickAndWaitForNewWindow();


        //is really visible? OK, this is NormalDistributionFragment
        UiObject2 tvNormal = mDevice.findObject(By.text("Нормальное распределение"));
        assertThat(tvNormal.isEnabled(), is(true));



        UiObject etNormMinX = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etNormMinX"));
        UiObject etNormMaxX = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etNormMaxX"));
        UiObject etU = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etU"));
        UiObject etQ = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etQ"));

        etNormMinX.click();
        etNormMinX.setText("-3");
        etNormMaxX.click();
        etNormMaxX.setText("3");
        etU.click();
        etU.setText("0");
        etQ.click();
        etQ.setText("1");

        //start new activity
        UiObject mBtnBuildNorm = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/btnBuildNormGraph"));
        mBtnBuildNorm.clickAndWaitForNewWindow();

        //if this button has exist -> this is new activity
        UiObject2 btnBack = mDevice.findObject(By.desc("Перейти вверх"));
        btnBack.click();

        String expectedText = etNormMinX.getText();

        assertThat(etNormMinX.getText(), is(expectedText));
    }

    @Test
    public void Negative_isHasTextAfterChangeOrientation() throws Exception {
        String expectedText = "5";

        UiObject mRadioNormal = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/radioNormal"));
        mRadioNormal.clickAndWaitForNewWindow();

        UiObject2 tvNormal = mDevice.findObject(By.text("Нормальное распределение"));
        assertThat(tvNormal.isEnabled(), is(true));

        UiObject etNormMinX = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etNormMinX"));

        etNormMinX.click();
        etNormMinX.setText(expectedText);

        assertThat(etNormMinX.getText(), is(expectedText));

        mDevice.setOrientationLeft();
        mDevice.setOrientationNatural();
        mDevice.unfreezeRotation();

        assertThat(etNormMinX.getText(), is(expectedText));
    }

    @After
    public void shutDown() throws RemoteException {
        mDevice.pressBack();
        mDevice.pressBack();
        mDevice.pressBack();
    }



}
