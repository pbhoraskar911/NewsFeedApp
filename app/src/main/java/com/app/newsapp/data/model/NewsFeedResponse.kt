package com.app.newsapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * @author Pranav Bhoraskar
 *
 */
@Parcelize
data class NewsFeedResponse(

        @SerializedName("status")
        @Expose
        var status: String? = null,
        @SerializedName("totalResults")
        @Expose
        var totalResults: Int? = null,
        @SerializedName("articles")
        @Expose
        var articles: List<Articles>? = null

) : Parcelable