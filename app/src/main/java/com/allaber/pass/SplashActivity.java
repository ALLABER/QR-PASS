package com.allaber.pass;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.allaber.pass.start.StartActivity;


public class SplashActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, StartActivity.class);
        this.startActivity(intent);
        this.finishAffinity();
    }
}
