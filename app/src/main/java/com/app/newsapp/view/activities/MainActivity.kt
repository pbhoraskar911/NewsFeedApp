package com.app.newsapp.view.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import com.app.newsapp.R
import com.app.newsapp.base.BaseActivity
import com.app.newsapp.data.model.NewsFeedResponse
import com.app.newsapp.utils.AlertDialogHelper
import com.app.newsapp.utils.isConnectedToInternet
import com.app.newsapp.view.fragment.ErrorFragment
import com.app.newsapp.view.fragment.NewsFeedFragment
import com.app.newsapp.viewmodels.MainViewModel
import com.app.newsapp.viewmodels.ViewModelFactory
import javax.inject.Inject


/**
 * @author Pranav Bhoraskar
 *
 * MainActivity class - extends BaseActivity
 */

class MainActivity : BaseActivity() {

    @BindView(R.id.progress_bar)
    lateinit var progressBar: ProgressBar

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var fragment: Fragment
    private lateinit var mainViewModel: MainViewModel

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showProgressBar()

        if (getCurrentContext().isConnectedToInternet()) {
            renderViewModel()
        }
        else {
            AlertDialogHelper.noInternetConnection(getCurrentContext(),
                    R.string.network_error, R.string.no_internet)
        }
    }

    fun renderViewModel() {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        loadNewsFeed()

        mainViewModel.newsApiSuccess().observe(this, Observer<NewsFeedResponse> {
            if (it != null) {
                setUpNewsFeedFragment(it)
            }
        })

        mainViewModel.newsApiLoader().observe(this, Observer<Boolean> {
            if (it != null) {
                hideProgressBar()
            }
        })

        mainViewModel.newsApiError().observe(this, Observer<String> {
            if (it != null) {
                setUpErrorFragment()
            }
        })
    }

    private fun setUpNewsFeedFragment(newsFeedResponse: NewsFeedResponse?) {
        fragment = NewsFeedFragment()
        val bundle = Bundle()
        bundle.putParcelable(getString(R.string.string_news_feed), newsFeedResponse)
        fragment.arguments = bundle
        replaceFragment(getFrameLayoutId(), fragment)
        hideProgressBar()
    }

    fun loadNewsFeed() {
        mainViewModel.fetchNewsFeed()
    }

    /**
     * Function to start ErrorFragment if the api response is not successful.
     */
    private fun setUpErrorFragment() {
        fragment = ErrorFragment()
        replaceFragment(getFrameLayoutId(), fragment)
        hideProgressBar()
    }

    private fun getFrameLayoutId() = R.id.frameLayout

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

    /**
     * Function to get the current context.
     *
     * @return Context
     */
    private fun getCurrentContext(): Context = this@MainActivity

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

    override fun onStop() {
        super.onStop()
        mainViewModel.disposeObserver()
    }
}