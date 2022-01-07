package com.allaber.pass;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.allaber.pass.home.navigator.HomeActivity;
import com.allaber.pass.slider.SliderActivity;
import com.allaber.pass.start.StartActivity;
import com.allaber.pass.utils.PreferenceManager;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.startActivity(getIntentActivity());
        this.finishAffinity();
    }

    private Intent getIntentActivity() {
        PreferenceManager preferenceManager = new PreferenceManager(this);

        if (preferenceManager.hasQrCode()) return new Intent(this, HomeActivity.class);

        if (preferenceManager.firstTimeLaunch()) return new Intent(this, SliderActivity.class);

        return new Intent(this, StartActivity.class);
    }
}
