package com.allaber.pass.start;

import static com.allaber.pass.utils.Thesaurus.PERMISSIONS_REQUEST_CAMERA;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.allaber.pass.R;
import com.allaber.pass.scanner.ScannerActivity;
import com.allaber.pass.utils.PreferenceManager;

public class StartPresenter {

    private StartActivity activity;
    private PreferenceManager preferenceManager;

    public StartPresenter(StartActivity activity) {
        this.activity = activity;
        this.preferenceManager = new PreferenceManager(activity);
    }

    public void setActivity() {
        if (hasCameraPermission())
            activity.startActivity(new Intent(activity, ScannerActivity.class));
        else
            getCameraPermission();

    }

    public void getCameraPermission() {
        int permissionStatus = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);

        if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, PERMISSIONS_REQUEST_CAMERA);
        }

        if (preferenceManager.hasCameraPermission()) {
            Toast.makeText(activity, activity.getResources().getString(R.string.string_camera_permission), Toast.LENGTH_SHORT).show();
        } else {
            preferenceManager.setCameraPermission(true);
        }
    }

    private boolean hasCameraPermission() {
        int permissionStatus = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        return permissionStatus == PackageManager.PERMISSION_GRANTED;
    }

    public void showManuallyDialog() {

    }
}
