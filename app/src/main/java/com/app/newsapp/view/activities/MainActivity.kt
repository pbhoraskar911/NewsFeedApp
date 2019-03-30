package com.app.newsapp.view.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import butterknife.BindView
import com.app.newsapp.R
import com.app.newsapp.base.BaseActivity
import com.app.newsapp.view.fragment.ErrorFragment


/**
 * @author Pranav Bhoraskar
 */

class MainActivity : BaseActivity() {

    @BindView(R.id.progress_bar)
    lateinit var progressBar: ProgressBar

    private lateinit var fragment: Fragment

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showProgressBar()
    }

    /**
     * Function to start ErrorFragment if the api response is not successful.
     */
    private fun setUpErrorFragment() {
        fragment = ErrorFragment()
        replaceFragment(R.id.frameLayout, fragment)
        hideProgressBar()
    }

    /**
     * Function to add/replace functions.
     * @param frameLayout Int : Layout id of the container
     * @param fragment Fragment to be loaded
     *
     */
    private fun replaceFragment(frameLayout: Int, fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        if (supportFragmentManager.backStackEntryCount < 1) {
            transaction.add(frameLayout, fragment).commit()
        }
        else {
            transaction.replace(frameLayout, fragment).commit()
        }
    }

    private fun showProgressBar() {
        if (progressBar != null && progressBar.visibility != View.VISIBLE) {
            progressBar.visibility = View.VISIBLE
        }
    }

    private fun hideProgressBar() {
        if (progressBar != null && progressBar.visibility != View.GONE) {
            progressBar.visibility = View.GONE
        }
    }
}