package com.app.newsapp.view.fragment


import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.BindView
import com.app.newsapp.R
import com.app.newsapp.base.BaseFragment
import com.app.newsapp.data.model.NewsFeedResponse
import com.app.newsapp.view.adapter.NewsFeedAdapter
import com.app.newsapp.viewmodels.MainViewModel
import com.app.newsapp.viewmodels.ViewModelFactory
import javax.inject.Inject

/**
 * @author Pranav Bhoraskar
 *
 * Fragment displays news feed data when api response is a success
 */

class NewsFeedFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.news_recycler_view)
    lateinit var newsRecyclerView: RecyclerView
    @BindView(R.id.swiperefresh)
    lateinit var swipeRefreshLayout: SwipeRefreshLayout


    var newsFeedResponse: NewsFeedResponse? = null

    private lateinit var adapter: NewsFeedAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    override fun layoutRes(): Int = R.layout.fragment_news_feed

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRefreshListener()
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        newsFeedResponse = arguments?.getParcelable(getString(R.string.string_news_feed))
        setUpRecyclerView(newsFeedResponse)
    }

    private fun setUpRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(this)
        swipeRefreshLayout.setNestedScrollingEnabled(true)
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimaryDark)
    }

    /**
     * Method to set up recycler view
     * @param response NewsFeedResponse
     */
    private fun setUpRecyclerView(response: NewsFeedResponse?) {

        val layoutManager = LinearLayoutManager(activity)
        newsRecyclerView.layoutManager = layoutManager

        val mDividerItemDecoration = DividerItemDecoration(
            getCurrentContext(),
            layoutManager.getOrientation()
        )
        newsRecyclerView.addItemDecoration(mDividerItemDecoration)

        adapter = NewsFeedAdapter(getCurrentContext(), response!!.articles)
        newsRecyclerView.adapter = adapter
        newsRecyclerView.setHasFixedSize(true)

        adapter.notifyDataSetChanged()

        animateRecyclerView()
    }

    /**
     * Method to animate Recycler View
     */
    private fun animateRecyclerView() {
        newsRecyclerView.startAnimation(AnimationUtils.loadAnimation(getCurrentContext(), R.anim.recycler_animation))
    }

    /**
     * SwipeRefreshLayout -> onRefresh method. Makes call to fetch news feed on refreshing the layout
     */
    override fun onRefresh() {
        if (swipeRefreshLayout.isRefreshing) {
            swipeRefreshLayout.isRefreshing = false
        }
        mainViewModel.fetchNewsFeed()
    }

    private fun getCurrentContext(): Activity? = activity
}
