package com.allaber.pass.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.allaber.pass.R;

public class StartActivity extends AppCompatActivity implements StartView {

    private StartPresenter startPresenter;
    private Button btnScanner;
    private Button btnManually;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initiationViewElements();
        setOnClickListener();
    }

    @Override
    public void initiationViewElements() {
        startPresenter = new StartPresenter(this);
        btnScanner = findViewById(R.id.btnScanner);
        btnManually = findViewById(R.id.btnManually);
    }

    @Override
    public void setOnClickListener() {
        btnScanner.setOnClickListener(this);
        btnManually.setOnClickListener(this);
    }

    @Override
    public AppCompatActivity getActivity() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnScanner:
                    startPresenter.setActivity();
                break;
            case R.id.btnManually:
                    startPresenter.showManuallyDialog();
                break;
        }
    }
}