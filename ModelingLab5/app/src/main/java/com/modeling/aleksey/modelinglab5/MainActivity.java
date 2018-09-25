package com.modeling.aleksey.modelinglab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        SimpleWebViewClient webViewClient = new SimpleWebViewClient();
        mWebView.setWebViewClient(webViewClient);

        mWebView.loadUrl("file:///android_asset/index.html");
    }
}