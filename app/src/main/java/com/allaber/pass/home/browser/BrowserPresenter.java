package com.allaber.pass.home.browser;

import android.view.View;

import com.allaber.pass.utils.PreferenceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class BrowserPresenter {

    private BrowserView view;
    private PreferenceManager preferenceManager;

    public BrowserPresenter(BrowserView view) {
        this.view = view;
        preferenceManager = new PreferenceManager(view.getContext());
    }

    public void loadQrCodeData() {
        new Thread(() -> {
            try {
                String content = getContent(preferenceManager.getQrCode());
                if (content == null) loadTextQrCode();

                view.loadWebViewData(content);

            } catch (IOException ex) {
                loadTextQrCode();
            }
        }).start();
    }

    private String getContent(String path) throws IOException {
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder buf = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            return (buf.toString());
        } catch (Exception exception) {
            return null;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void loadTextQrCode() {
        view.getActivity().runOnUiThread(() -> {
            String content = preferenceManager.getQrCode();
            view.loadTextViewData(content);
        });
    }
}
