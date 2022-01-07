package com.allaber.pass.home.navigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.allaber.pass.R;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initiationViewElements();
        setOnClickListener();
    }

    @Override
    public void initiationViewElements() {
        homePresenter = new HomePresenter(this);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void setOnClickListener() {

    }

    @Override
    public AppCompatActivity getActivity() {
        return this;
    }

    @Override
    public void onClick(View v) {

    }
}