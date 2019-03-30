package com.app.newsapp.view.fragment


import android.os.Bundle
import android.view.View
import com.app.newsapp.R
import com.app.newsapp.base.BaseFragment

/**
 * @author Pranav Bhoraskar
 */

class NewsFeedFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_news_feed

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}