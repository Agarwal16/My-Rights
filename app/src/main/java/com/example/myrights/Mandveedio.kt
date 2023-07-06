package com.example.myrights

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Mandveedio : AppCompatActivity() {
    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mandveedio)

        webView = findViewById<View>(R.id.webView) as WebView
        webView!!.webViewClient = WebViewClient()
        webView!!.loadUrl("https://www.youtube.com/watch?v=XZxLXBvbpIs&t=899s")
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