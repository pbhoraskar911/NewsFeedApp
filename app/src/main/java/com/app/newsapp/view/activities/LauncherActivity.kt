package com.app.newsapp.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.app.newsapp.R
import com.app.newsapp.base.BaseActivity

class LauncherActivity : BaseActivity() {

    private val SPLASH_TIME = 1000

    override fun layoutRes(): Int = R.layout.activity_launcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                navigateToMainActivity()
                finish()
                handler.removeCallbacks(this)
            }
        }, SPLASH_TIME.toLong())
    }

    private fun navigateToMainActivity() {
        val intent = Intent(getCurrentContext(), MainActivity::class.java)
        getCurrentContext().startActivity(intent)
    }

    private fun getCurrentContext(): Context = this@LauncherActivity
}
