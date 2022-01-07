package com.allaber.pass.home.qr;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.pass.R;
import com.allaber.pass.utils.common.BaseFragmentView;

public class QrFragment extends Fragment implements QrView {

    private QrPresenter qrPresenter;

    private ImageView imgQR;
    private Button btnShare;
    private Button btnCopy;
    private Button btnRemove;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qr, container, false);
        initiationViewElements(view);
        setOnClickListener();
        qrPresenter.setQrCodeImage();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        qrPresenter = new QrPresenter(this);

        imgQR = view.findViewById(R.id.imgQR);
        btnShare = view.findViewById(R.id.btnShare);
        btnCopy = view.findViewById(R.id.btnCopy);
        btnRemove = view.findViewById(R.id.btnRemove);
    }

    @Override
    public void setOnClickListener() {
        btnShare.setOnClickListener(this);
        btnCopy.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShare:
                qrPresenter.shareQrCode();
                break;
            case R.id.btnCopy:
                qrPresenter.copyQrCode();
                break;
            case R.id.btnRemove:
                qrPresenter.removeQrCode();
                break;
        }
    }

    public static QrFragment newInstance() {
        return new QrFragment();
    }

    @Override
    public void setQrCodeImage(Bitmap qrCode) {
        imgQR.setImageBitmap(qrCode);
    }
}
