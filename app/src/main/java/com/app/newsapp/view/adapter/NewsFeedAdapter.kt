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
import com.squareup.picasso.Picasso


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

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindData(adapterPosition: Int, article: Articles) {
            setNewsTitle(article)
            setNewsDescription(article)
            setNewsImage(article)
        }

        private fun setNewsImage(article: Articles) {
            Picasso.get()
                .load(article.urlToImage)
                .fit()
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