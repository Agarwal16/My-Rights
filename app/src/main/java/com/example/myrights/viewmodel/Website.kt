package com.example.myrights.viewmodel

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.myrights.R

class Website : AppCompatActivity() {
    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById<View>(R.id.webView) as WebView
        webView!!.webViewClient = WebViewClient()
        webView!!.loadUrl("https://eci.gov.in/")
        val webSettings = webView!!.settings
        webSettings.javaScriptEnabled = true

    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}