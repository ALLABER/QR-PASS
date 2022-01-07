package com.allaber.pass.slider;

import android.content.Intent;

import com.allaber.pass.home.navigator.HomeActivity;
import com.allaber.pass.start.StartActivity;
import com.allaber.pass.utils.PreferenceManager;

public class SliderPresenter {

    private PreferenceManager preferenceManager;
    private SliderView view;

    public SliderPresenter(SliderView view) {
        this.view = view;
        preferenceManager = new PreferenceManager(view.getActivity());
    }

    public void setActivity() {
        Intent intent;
        if (preferenceManager.hasQrCode())
            intent = new Intent(view.getActivity(), HomeActivity.class);
        else
            intent = new Intent(view.getActivity(), StartActivity.class);

        view.getActivity().startActivity(intent);
        view.getActivity().finishAffinity();
    }

    public void nextScreen() {
        int i = view.getItemPosition(+1);
        if (i < view.getIntroScreensLength()) {
            view.setCurrentItem(i);
        } else {
            setActivity();
        }
    }
}
