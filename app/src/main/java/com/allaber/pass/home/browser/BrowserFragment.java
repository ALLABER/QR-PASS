package com.allaber.pass.home.browser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.pass.R;

public class BrowserFragment extends Fragment implements BrowserView{

    private BrowserPresenter browserPresenter;

    private ProgressBar progressBar;
    private WebView webView;
    private TextView txtQrCode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browser, container, false);
        initiationViewElements(view);
        setOnClickListener();

        browserPresenter.loadQrCodeData();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        browserPresenter = new BrowserPresenter(this);

        txtQrCode = view.findViewById(R.id.textViewQrCode);
        progressBar = view.findViewById(R.id.progressBar);

        webView = view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    @Override
    public void setOnClickListener() {

    }

    @Override
    public void onClick(View v) {

    }

    public static BrowserFragment newInstance() {
        return new BrowserFragment();
    }

    @Override
    public void loadWebViewData(String content) {
        webView.post(() -> {
            webView.loadDataWithBaseURL(content, content, "text/html", "UTF-8", "https://stackoverflow.com/");
            progressBar.setVisibility(View.INVISIBLE);
        });
    }

    @Override
    public void loadTextViewData(String content) {
        txtQrCode.setVisibility(View.VISIBLE);
        txtQrCode.setText(content);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
