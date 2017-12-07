package com.caoyanglong.adarticle.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.base.BaseLazyFragment;
import com.caoyanglong.adarticle.utils.Constants;
import com.caoyanglong.adarticle.web.WebDetailActivity;

/**
 * Created by cyl
 * on 2017/2/8.
 * email:670654904@qq.com
 */
public class NewsFragment extends BaseLazyFragment {
    private WebView webview;
    private ProgressBar progressBar;
    private WebView attempWeb;
    @Override
    public int setContentView() {
        return R.layout.news_fragment_layout;
    }

    @Override
    public void initView(View view) {
        webview = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.load_progress);
    }

    @Override
    public void initData() {
        attempWeb = new WebView(getContext());
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
//                Log.d("<loadurl_url>",url);
//                view.loadUrl(url);
                Intent intent = new Intent(getActivity(), WebDetailActivity.class);
                intent.putExtra(com.caoyanglong.adarticle.utils.Constants.LOAD_URL,url);
                startActivity(intent);
                return true;
            }
        });
        String loadUrl = getArguments().getString(Constants.LOAD_URL);
        if(TextUtils.equals(loadUrl,"http://news.sohu.com/")){
            attempWeb.loadUrl(getArguments().getString(Constants.LOAD_URL));
        }
        else{
            webview.loadUrl(getArguments().getString(Constants.LOAD_URL));

        }
        attempWeb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webview.loadUrl(url);
            }
        });
    }

    @Override
    public void initListener() {

    }

    public static NewsFragment getInstance(Bundle bundle){
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.setArguments(bundle);
        return newsFragment;
    }
}
