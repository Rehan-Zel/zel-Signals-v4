package com.zelsign.zelsignals

import android.app.Activity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.os.Handler
import android.view.View

class MainActivity : Activity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = WebView(this)
        setContentView(webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = true

        // Show splash screen
        val splashScreen = View(this)
        splashScreen.setBackgroundResource(R.drawable.splash)
        setContentView(splashScreen)

        Handler().postDelayed({
            setContentView(webView)
            webView.loadUrl("file:///android_asset/index.html")
        }, 1500)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
