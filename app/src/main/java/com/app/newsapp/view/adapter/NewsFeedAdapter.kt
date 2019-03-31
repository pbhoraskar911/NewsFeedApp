package com.app.newsapp.view.adapter

import android.content.Context
import android.content.Intent
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
import com.app.newsapp.utils.convertDate
import com.app.newsapp.view.activities.WebViewActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


/**
 * @author Pranav Bhoraskar
 *
 * RecyclerView Adapter for populating the list using the incoming data
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
        holder.bindData(holder.adapterPosition, listOfArticles!![holder.adapterPosition])

        holder.itemView.setOnClickListener {
            val newsUrl = listOfArticles!![holder.adapterPosition].url

            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(context!!.getString(R.string.news_url), newsUrl)
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return if (listOfArticles != null) listOfArticles!!.size else 0
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.image_news)
        lateinit var newsImage: ImageView
        @BindView(R.id.news_headline)
        lateinit var newsHeadline: TextView
        @BindView(R.id.news_description)
        lateinit var newsDescription: TextView
        @BindView(R.id.news_timestamp)
        lateinit var newsTimestamp: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindData(adapterPosition: Int, article: Articles) {
            setNewsTitle(article)
            setNewsDescription(article)
            setNewsImage(article)
            setNewsTimestamp(article)
        }

        private fun setNewsTimestamp(article: Articles) {
            newsTimestamp.text = article.publishedAt!!.convertDate()
        }

        private fun setNewsImage(article: Articles) {
            Glide.with(context!!)
                .load(article.urlToImage)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(newsImage)
        }

        private fun setNewsTitle(article: Articles) {
            newsHeadline.text = article.title
        }

        private fun setNewsDescription(article: Articles) {
            newsDescription.text = article.description
        }
    }
}