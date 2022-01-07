package com.allaber.pass.utils.common;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public interface BaseActivityView extends View.OnClickListener {
    void initiationViewElements();
    void setOnClickListener();
    AppCompatActivity getActivity();
}
