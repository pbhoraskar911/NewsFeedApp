package com.app.newsapp.view.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import butterknife.BindView
import com.app.newsapp.R
import com.app.newsapp.base.BaseFragment
import com.app.newsapp.utils.AlertDialogHelper
import com.app.newsapp.utils.isConnectedToInternet
import com.app.newsapp.view.activities.MainActivity

/**
 * @author Pranav Bhoraskar
 *
 * Frament displays Error if news feed fetch is failed
 *
 */
class ErrorFragment : BaseFragment() {

    @BindView(R.id.button_close)
    lateinit var buttonClose: Button

    override fun layoutRes(): Int = R.layout.fragment_error

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonClose.setOnClickListener {
            if (getCurrentContext()!!.isConnectedToInternet()) {
                (getCurrentContext() as MainActivity).onBackPressed()
            }
            else {
                AlertDialogHelper.noInternetConnection(
                        getCurrentContext() as MainActivity,
                        R.string.network_error,
                        R.string.no_internet
                )
            }
        }
    }

    private fun getCurrentContext(): Activity? = activity
}