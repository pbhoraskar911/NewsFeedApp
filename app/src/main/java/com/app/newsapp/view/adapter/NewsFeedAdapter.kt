package com.app.newsapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.app.newsapp.R
import com.app.newsapp.data.model.Articles


/**
 * Created by Pranav Bhoraskar
 */
class NewsFeedAdapter(
        var context: Context?,
        var listOfArticles: List<Articles>?
) : RecyclerView.Adapter<NewsFeedAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val holder = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row_news_feed, parent, false)
        return NewsViewHolder(holder)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return if (listOfArticles != null) listOfArticles!!.size else 0
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.image_news)
        lateinit var newsimage: ImageView
        @BindView(R.id.news_headline)
        lateinit var newsHeadline: TextView
        @BindView(R.id.news_description)
        lateinit var newsDescription: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}