package com.allaber.pass.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.allaber.pass.R;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;

public class ScannerActivity extends AppCompatActivity implements ScannerView {

    private CodeScannerView mScannerView;
    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initiationViewElements();
        setOnClickListener();
    }

    @Override
    public void initiationViewElements() {
        mScannerView = findViewById(R.id.scanner_view);
        mScannerView = findViewById(R.id.scanner_view);
        mScannerView.setOnClickListener(view -> mCodeScanner.startPreview());
        mCodeScanner = new CodeScanner(this, mScannerView);
//      mCodeScanner.setDecodeCallback(result -> this.runOnUiThread(() -> setToMainActivity(result.getText())));
    }

    @Override
    public void setOnClickListener() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}