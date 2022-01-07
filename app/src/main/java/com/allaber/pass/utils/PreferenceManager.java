package com.allaber.pass.utils;

import static com.allaber.pass.utils.Thesaurus.APP_PREFERENCES;
import static com.allaber.pass.utils.Thesaurus.CAMERA_PERMISSION;
import static com.allaber.pass.utils.Thesaurus.FIRST_LAUNCH;
import static com.allaber.pass.utils.Thesaurus.QR_CODE;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;
    Context context;

    int SHARED_PREFERENCES_MODE = 0;

    public PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, SHARED_PREFERENCES_MODE);
        spEditor = sharedPreferences.edit();
    }

    public boolean hasCameraPermission() {
        return sharedPreferences.getBoolean(CAMERA_PERMISSION, false);
    }

    public void setCameraPermission(boolean camera_permission) {
        spEditor.putBoolean(CAMERA_PERMISSION, camera_permission);
        spEditor.apply();
    }

    public String getQrCode() {
        return sharedPreferences.getString(QR_CODE, null);
    }

    public void setQrCode(String qrCode) {
        spEditor.putString(QR_CODE, qrCode);
        spEditor.apply();
    }

    public boolean hasQrCode() {
        String qrCode = sharedPreferences.getString(QR_CODE, null);
        return !Utils.isBlankString(qrCode);
    }

    public boolean firstTimeLaunch() {
        boolean firstTime = sharedPreferences.getBoolean(FIRST_LAUNCH, true);
        setFirstTimeLaunch(false);
        return firstTime;
    }

    public void setFirstTimeLaunch(boolean firstTime) {
        spEditor.putBoolean(FIRST_LAUNCH, firstTime);
        spEditor.apply();
    }
}