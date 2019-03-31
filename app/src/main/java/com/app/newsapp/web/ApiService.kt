package com.app.newsapp.web

import com.app.newsapp.data.model.NewsFeedResponse
import io.reactivex.Observable
import org.jetbrains.annotations.NotNull
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 * @author Pranav Bhoraskar
 *
 * Interface provides all the api calls required to fetch different data
 */

interface ApiService {

    @GET("top-headlines")
    fun fetchNewsFeed(
        @QueryMap hashMap: @NotNull HashMap<String, String>,
        @QueryMap hashMapPagination: @NotNull HashMap<String, Int>
    ): @NotNull Observable<NewsFeedResponse>
}