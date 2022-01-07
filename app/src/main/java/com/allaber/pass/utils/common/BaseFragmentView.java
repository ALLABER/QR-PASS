package com.allaber.pass.utils.common;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

public interface BaseFragmentView extends View.OnClickListener {
    void initiationViewElements(View view);
    void setOnClickListener();
    Context getContext();
    FragmentActivity getActivity();
}
