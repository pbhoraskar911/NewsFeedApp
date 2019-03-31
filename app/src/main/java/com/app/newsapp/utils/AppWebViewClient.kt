package com.app.newsapp.utils

import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView

/**
 * Created by Pranav Bhoraskar
 */
class AppWebViewClient(private val progressBar: ProgressBar, private val newsPageTextView: TextView) : WebViewClient() {

    init {
        progressBar.visibility = View.VISIBLE
        newsPageTextView.visibility = View.VISIBLE
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
        newsPageTextView.visibility = View.GONE
    }
}