package com.app.newsapp.view.activities

import android.os.Bundle
import com.app.newsapp.R
import com.app.newsapp.base.BaseActivity


/**
 * @author Pranav Bhoraskar
 */

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
