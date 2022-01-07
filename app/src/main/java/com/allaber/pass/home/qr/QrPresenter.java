package com.allaber.pass.home.qr;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.allaber.pass.R;
import com.allaber.pass.dialog.DeleteDialog;
import com.allaber.pass.utils.PreferenceManager;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QrPresenter {

    private QrView view;
    private PreferenceManager preferenceManager;

    public QrPresenter(QrView view) {
        this.view = view;
        preferenceManager = new PreferenceManager(getContext());
    }

    public void shareQrCode() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.string_share_body) + "\n\n");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getQrCode());
        startActivity(sharingIntent);
    }

    public void copyQrCode() {
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(getString(R.string.string_qr_code), getQrCode());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getContext(), R.string.string_copied, Toast.LENGTH_SHORT).show();
    }

    public void removeQrCode() {
        DeleteDialog oldDeleteDialogFragment = new DeleteDialog();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        oldDeleteDialogFragment.show(transaction, "DeleteDialog");
    }

    private Context getContext(){
        return view.getContext();
    }

    private FragmentActivity getActivity(){
        return view.getActivity();
    }

    private String getString(int stringId){
        return getContext().getString(stringId);
    }

    private void startActivity(Intent sharingIntent) {
        getContext().startActivity(Intent.createChooser(sharingIntent, getString(R.string.string_share_qr_code)));
    }

    private String getQrCode(){
        return preferenceManager.getQrCode();
    }

    public void setQrCodeImage() {
        String qrCode = preferenceManager.getQrCode();
        QRGEncoder qrgEncoder = new QRGEncoder(qrCode, null, QRGContents.Type.TEXT, 1000);
        qrgEncoder.setColorBlack(Color.BLACK);
        Bitmap bitmap = qrgEncoder.getBitmap();
        view.setQrCodeImage(bitmap);
    }
}
