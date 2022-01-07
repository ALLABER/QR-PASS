package com.allaber.pass.home.browser;

import com.allaber.pass.utils.common.BaseFragmentView;

public interface BrowserView extends BaseFragmentView {
    void loadWebViewData(String content);
    void loadTextViewData(String content);
}
