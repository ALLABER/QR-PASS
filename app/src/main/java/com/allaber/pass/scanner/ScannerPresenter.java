package com.allaber.pass.scanner;

import android.content.Intent;

import com.allaber.pass.home.navigator.HomeActivity;
import com.allaber.pass.utils.PreferenceManager;

public class ScannerPresenter {

    private ScannerView view;
    private PreferenceManager preferenceManager;

    public ScannerPresenter(ScannerView view) {
        this.view = view;
        preferenceManager = new PreferenceManager(view.getActivity());
    }

    public void setToHomeActivity(String qrCode) {
        preferenceManager.setQrCode(qrCode);
        Intent intent = new Intent(view.getActivity(), HomeActivity.class);
        view.getActivity().startActivity(intent);
        view.getActivity().finishAffinity();
    }
}
