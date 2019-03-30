package com.app.newsapp.utils

import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

/**
 * Created by Pranav Bhoraskar
 */
class AppWebViewClient(private val progressBar: ProgressBar) : WebViewClient() {

    init {
        progressBar.visibility = View.VISIBLE
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }
}