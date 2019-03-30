package com.app.newsapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by Pranav Bhoraskar
 */
@Parcelize
data class Articles(
    @SerializedName("source")
    @Expose
    private var source: Source? = null,
    @SerializedName("author")
    @Expose
    private var author: String? = null,
    @SerializedName("title")
    @Expose
    private var title: String? = null,
    @SerializedName("description")
    @Expose
    private var description: String? = null,
    @SerializedName("url")
    @Expose
    private var url: String? = null,
    @SerializedName("urlToImage")
    @Expose
    private var urlToImage: String? = null,
    @SerializedName("publishedAt")
    @Expose
    private var publishedAt: String? = null,
    @SerializedName("content")
    @Expose
    private val content: String? = null
) : Parcelable