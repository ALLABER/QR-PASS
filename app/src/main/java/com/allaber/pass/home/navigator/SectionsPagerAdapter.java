package com.allaber.pass.home.navigator;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.allaber.pass.R;
import com.allaber.pass.home.browser.BrowserFragment;
import com.allaber.pass.home.qr.QrFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] screens = new int[]{R.string.string_tab_text_1, R.string.string_tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return QrFragment.newInstance();
            default: return BrowserFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(screens[position]);
    }

    @Override
    public int getCount() {
        return screens.length;
    }
}
