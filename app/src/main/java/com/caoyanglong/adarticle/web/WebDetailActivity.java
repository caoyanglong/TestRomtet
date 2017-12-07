package com.caoyanglong.adarticle.web;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.utils.Constants;


/**
 * Created by CYL on 16-9-10.
 * email:670654904@qq.com
 */
public class WebDetailActivity extends Activity {
    private WebView webview;
    private ProgressBar progressBar;
    private LinearLayout topAdContainer, bottomContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_detail_layout);
        webview = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.load_progress);
        topAdContainer = (LinearLayout) findViewById(R.id.top_banner);
        bottomContainer = (LinearLayout) findViewById(R.id.bottom_banner);

        WebSettings webSet = webview.getSettings();
        webSet.setJavaScriptEnabled(true);
        webSet.setJavaScriptCanOpenWindowsAutomatically(true);
        webSet.setDefaultTextEncodingName("utf-8");
        webSet.setLoadWithOverviewMode(true);
        webSet.setUseWideViewPort(true);
        webSet.setDomStorageEnabled(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            webSet.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    if (progressBar.getVisibility() == View.GONE)
                        progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        webview.setInitialScale(100);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("<loadurl_url>",url);
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl(getIntent().getStringExtra(Constants.LOAD_URL));


    }


}
