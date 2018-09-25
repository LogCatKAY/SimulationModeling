package com.modeling.aleksey.modelinglab1;

import android.content.Context;
import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by korchagin on 27.03.18.
 */
@RunWith(AndroidJUnit4.class)
public class UiAutomatorNegativeTest {

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
    public void Negative_buildGraphWithIncorrectParameters() throws UiObjectNotFoundException {
        UiObject etMinX = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etMinX"));
        UiObject etMaxX = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etMaxX"));
        UiObject etA = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etA"));
        UiObject etB = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/etB"));

        etMinX.click();
        etMinX.setText("-1");
        etMaxX.click();
        etMaxX.setText("4");
        etA.click();
        etA.setText("2");
        etB.click();
        etB.setText("2");

        UiObject mBtnBuildUniform = mDevice.findObject(new UiSelector()
                .resourceId("com.modeling.aleksey.modelinglab1:id/btnBuildGraph"));
        mBtnBuildUniform.clickAndWaitForNewWindow();
    }
}
