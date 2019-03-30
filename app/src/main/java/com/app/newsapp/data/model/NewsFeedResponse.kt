package com.app.newsapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by Pranav Bhoraskar
 */
@Parcelize
data class NewsFeedResponse(

    @SerializedName("status")
    @Expose
    private var status: String? = null,
    @SerializedName("totalResults")
    @Expose
    private var totalResults: Int? = null,
    @SerializedName("articles")
    @Expose
    private var articles: List<Articles>? = null

) : Parcelable