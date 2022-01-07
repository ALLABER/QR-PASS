package com.allaber.pass.utils;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import junit.framework.TestCase;

import org.junit.Test;


public class PreferenceManagerTest extends TestCase {

    private Context context = ApplicationProvider.getApplicationContext();

    @Test
    public void testCameraPermission() {
        PreferenceManager preferenceManager = new PreferenceManager(context);

        preferenceManager.setCameraPermission(false);
        assertEquals(preferenceManager.hasCameraPermission(), false);

        preferenceManager.setCameraPermission(true);
        assertEquals(preferenceManager.hasCameraPermission(), true);
    }


    @Test
    public void testQrCode() {

        PreferenceManager preferenceManager = new PreferenceManager(context);

        preferenceManager.setQrCode(null);
        assertEquals(preferenceManager.getQrCode(), null);
        assertEquals(preferenceManager.hasQrCode(), false);

        preferenceManager.setQrCode("test");
        assertEquals(preferenceManager.getQrCode(), "test");
        assertEquals(preferenceManager.hasQrCode(), true);
    }

    @Test
    public void testFirstTimeLaunch() {
        PreferenceManager preferenceManager = new PreferenceManager(context);

        preferenceManager.setFirstTimeLaunch(true);
        assertEquals(preferenceManager.firstTimeLaunch(), true);
        assertEquals(preferenceManager.firstTimeLaunch(), false);
    }
}