package com.example.myrights.viewmodel.violation.video

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myrights.R
import com.example.myrights.viewmodel.Web2

class Quovedio : AppCompatActivity() {
    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quovedio)

        webView = findViewById<View>(R.id.webView) as WebView
        webView!!.webViewClient = WebViewClient()
        webView!!.loadUrl("https://www.youtube.com/watch?v=GnuH59hQWfw&t=3s")
        val webSettings = webView!!.settings
        webSettings.javaScriptEnabled = true

        val button = findViewById<Button>(R.id.web)
        button.setOnClickListener{
            val intent = Intent(this, Web2::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}