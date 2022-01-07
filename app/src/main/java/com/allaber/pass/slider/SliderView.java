package com.allaber.pass.slider;

import com.allaber.pass.utils.common.BaseActivityView;

public interface SliderView extends BaseActivityView {
    int getItemPosition(int position);
    int getIntroScreensLength();
    void setCurrentItem(int itemPosition);
}
