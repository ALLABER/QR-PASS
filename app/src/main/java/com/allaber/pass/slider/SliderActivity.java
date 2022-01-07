package com.allaber.pass.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.allaber.pass.R;

public class SliderActivity extends AppCompatActivity implements SliderView, ViewPager.OnPageChangeListener {

    private SliderPresenter sliderPresenter;

    private int[] intro_screens = new int[]{R.layout.intro_screen_1, R.layout.intro_screen_2, R.layout.intro_screen_3};
    private SliderPagerAdapter sliderPagerAdapter;
    private TextView txtSkip;
    private Button btnNext;
    private ViewPager viewPagerSlider;
    private ImageView imgPoint1, imgPoint2, imgPoint3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        initiationViewElements();
        setOnClickListener();
        setIndicatorsAlpha(0);
    }

    @Override
    public void initiationViewElements() {
        sliderPresenter = new SliderPresenter(this);

        txtSkip = findViewById(R.id.txtSkip);
        btnNext = findViewById(R.id.btnNext);

        imgPoint1 = findViewById(R.id.imgPoint1);
        imgPoint2 = findViewById(R.id.imgPoint2);
        imgPoint3 = findViewById(R.id.imgPoint3);

        viewPagerSlider = findViewById(R.id.viewPagerSlider);

        sliderPagerAdapter = new SliderPagerAdapter(this, intro_screens);
        viewPagerSlider.setAdapter(sliderPagerAdapter);
        viewPagerSlider.addOnPageChangeListener(this);
    }

    @Override
    public void setOnClickListener() {
        txtSkip.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtSkip:
                sliderPresenter.setActivity();
                break;
            case R.id.btnNext:
                sliderPresenter.nextScreen();
                break;
        }
    }

    @Override
    public AppCompatActivity getActivity() {
        return this;
    }

    @Override
    public int getItemPosition(int position) {
        return viewPagerSlider.getCurrentItem() + position;
    }

    @Override
    public int getIntroScreensLength() {
        return intro_screens.length;
    }

    @Override
    public void setCurrentItem(int itemPosition) {
        viewPagerSlider.setCurrentItem(itemPosition);
    }

    @Override
    public void onPageSelected(int position) {
        setIndicatorsAlpha(position);
        if (position == intro_screens.length - 1) {
            btnNext.setText(getResources().getString(R.string.string_ok));
            txtSkip.setVisibility(View.GONE);
        } else {
            btnNext.setText(getResources().getString(R.string.string_next));
            txtSkip.setVisibility(View.VISIBLE);
        }
    }

    private void setIndicatorsAlpha(int position) {
        imgPoint1.setImageAlpha(78);
        imgPoint2.setImageAlpha(78);
        imgPoint3.setImageAlpha(78);

        switch (position) {
            case 0:
                imgPoint1.setImageAlpha(255);
                break;
            case 1:
                imgPoint2.setImageAlpha(255);
                break;
            case 2:
                imgPoint3.setImageAlpha(255);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}