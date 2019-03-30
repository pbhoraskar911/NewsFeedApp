package com.app.newsapp.view.fragment


import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.app.newsapp.R
import com.app.newsapp.base.BaseFragment
import com.app.newsapp.data.model.NewsFeedResponse
import com.app.newsapp.view.adapter.NewsFeedAdapter

/**
 * @author Pranav Bhoraskar
 *
 * Fragment displays news feed data when api response is a success
 */

class NewsFeedFragment : BaseFragment() {

    @BindView(R.id.news_recycler_view)
    lateinit var newsRecyclerView: RecyclerView

    var newsFeedResponse : NewsFeedResponse?=null

    override fun layoutRes(): Int = R.layout.fragment_news_feed

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsFeedResponse = arguments?.getParcelable(getString(R.string.string_news_feed))
        setUpRecyclerView(newsFeedResponse)
    }

    private lateinit var adapter: NewsFeedAdapter

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

    private fun getCurrentContext(): Activity? = activity
}
