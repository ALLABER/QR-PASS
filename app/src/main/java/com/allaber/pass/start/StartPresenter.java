package com.allaber.pass.start;

import static com.allaber.pass.utils.Thesaurus.PERMISSIONS_REQUEST_CAMERA;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.allaber.pass.R;
import com.allaber.pass.dialog.ManuallyDialog;
import com.allaber.pass.scanner.ScannerActivity;
import com.allaber.pass.utils.PreferenceManager;

public class StartPresenter {

    private StartView view;
    private PreferenceManager preferenceManager;

    public StartPresenter(StartActivity view) {
        this.view = view;
        this.preferenceManager = new PreferenceManager(view);
    }

    public void setActivity() {
        if (hasCameraPermission())
            getActivity().startActivity(new Intent(getActivity(), ScannerActivity.class));
        else
            getCameraPermission();
    }

    public void getCameraPermission() {
        int permissionStatus = ContextCompat.checkSelfPermission(view.getActivity(), Manifest.permission.CAMERA);

        if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, PERMISSIONS_REQUEST_CAMERA);
        }

        if (preferenceManager.hasCameraPermission()) {
            Toast.makeText(view.getActivity(), view.getActivity().getResources().getString(R.string.string_camera_permission), Toast.LENGTH_SHORT).show();
        } else {
            preferenceManager.setCameraPermission(true);
        }
    }

    private boolean hasCameraPermission() {
        int permissionStatus = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
        return permissionStatus == PackageManager.PERMISSION_GRANTED;
    }

    public void showManuallyDialog() {
        ManuallyDialog manuallyDialogFragment = new ManuallyDialog();
        FragmentManager manager = view.getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        manuallyDialogFragment.show(transaction, "ManuallyDialog");
    }

    private AppCompatActivity getActivity(){
        return view.getActivity();
    }
}
