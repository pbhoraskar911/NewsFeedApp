package com.app.newsapp.view.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import com.app.newsapp.R
import com.app.newsapp.base.BaseActivity
import com.app.newsapp.utils.AppWebViewClient

class WebViewActivity : BaseActivity() {

    @BindView(R.id.webview)
    lateinit var webView: WebView
    @BindView(R.id.text_news_page)
    lateinit var newsPageTextView: TextView
    @BindView(R.id.no_web_page)
    lateinit var noPageFoundTextView: TextView
    @BindView(R.id.progress_bar_webview)
    lateinit var progressBar: ProgressBar

    override fun layoutRes(): Int = R.layout.activity_web_view

    private var pageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent != null) {
            pageUrl = intent.getStringExtra(getString(R.string.news_url))
            openWebPage(pageUrl)
        }
    }

    private fun openWebPage(pageUrl: String?) {
        if (pageUrl == "") {
            noPageFoundTextView.visibility = View.VISIBLE
        } else {
            noPageFoundTextView.visibility = View.GONE
            webView.visibility = View.VISIBLE

            webView.webViewClient = AppWebViewClient(progressBar, newsPageTextView)

            val webSettings = webView.settings
            webSettings.javaScriptEnabled = true
            webView.loadUrl(pageUrl)
        }
    }

    /**
     * Function to display progress bar if it is not null.
     */
    fun showProgressBar() {
        if (progressBar != null && progressBar.visibility != View.VISIBLE) {
            progressBar.visibility = View.VISIBLE
        }
    }

    /**
     * Function to hide the visible progress bar if it is not null.
     */
    private fun hideProgressBar() {
        if (progressBar != null && progressBar.visibility != View.GONE) {
            progressBar.visibility = View.GONE
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
