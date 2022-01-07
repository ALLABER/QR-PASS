package com.allaber.pass.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

public class SliderPagerAdapter extends PagerAdapter {

    private LayoutInflater inflater;
    private int[] screens;
    private Context mContext;

    public SliderPagerAdapter(Context mContext, int[] screens) {
        this.mContext = mContext;
        this.screens = screens;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(screens[position], container, false);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return screens.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = (View) object;
        container.removeView(v);
    }

    @Override
    public boolean isViewFromObject(View v, Object object) {
        return v == object;
    }
}