package com.app.newsapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(

    @SerializedName("id")
    @Expose
    private var id: String? = null,
    @SerializedName("name")
    @Expose
    private var name: String? = null

) : Parcelable