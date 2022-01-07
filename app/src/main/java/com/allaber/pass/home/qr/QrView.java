package com.allaber.pass.home.qr;

import android.graphics.Bitmap;

import com.allaber.pass.utils.common.BaseFragmentView;

public interface QrView extends BaseFragmentView {
    void setQrCodeImage(Bitmap qrCode);
}
