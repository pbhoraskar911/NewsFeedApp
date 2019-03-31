package com.app.newsapp.web

import com.app.newsapp.data.model.NewsFeedResponse
import io.reactivex.Observable
import org.jetbrains.annotations.NotNull
import retrofit2.http.GET


/**
 * @author Pranav Bhoraskar
 *
 * Interface provides all the api calls required to fetch different data
 */

interface ApiService {

    @GET("top-headlines")
    fun fetchNewsFeed(): @NotNull Observable<NewsFeedResponse>
}