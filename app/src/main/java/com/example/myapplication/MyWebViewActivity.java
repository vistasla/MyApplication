package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MyWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
    }
    protected void onStart() {
        super.onStart();
        Log.d("MyWebViewActivity:", "onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.d("MyWebViewActivity:", "onResume");
        /*WebView webView=new WebView(getApplicationContext());
        String weatherString="https://weathernew.pae.baidu.com/weathernew/pc?query=%E6%B2%B3%E5%8D%97%E9%83%91%E5%B7%9E%E5%A4%A9%E6%B0%94&srcid=4982&forecast=long_day_forecast";
        webView.loadUrl(weatherString);*/
        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //myWebView.loadUrl("https://weathernew.pae.baidu.com/weathernew/pc?query=%E6%B2%B3%E5%8D%97%E9%83%91%E5%B7%9E%E5%A4%A9%E6%B0%94&srcid=4982&forecast=long_day_forecast");
        //myWebView.loadUrl("https://developer.android.google.cn/guide/webapps?hl=zh-cn");
        //myWebView.loadUrl("https://ms.mbd.baidu.com/r/XGTHsr6PZK?f=cp&u=3097818fa9441573");
        //https://m.baidu.com/sf?pd=life_compare_weather&openapi=1&dspName=iphone&from_sf=1&resource_id=4982&oe=utf8&alr=1&multiDayWeather=1&title=40%E5%A4%A9%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5&query=%E9%83%91%E5%B7%9E%E4%B8%AD%E5%8E%9F%E5%A4%A9%E6%B0%94
        myWebView.loadUrl("https://m.baidu.com/sf?pd=life_compare_weather&openapi=1&dspName=iphone&from_sf=1&resource_id=4982&oe=utf8&alr=1&multiDayWeather=1&title=40%E5%A4%A9%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5&query=%E9%83%91%E5%B7%9E%E4%B8%AD%E5%8E%9F%E5%A4%A9%E6%B0%94");
    }
}