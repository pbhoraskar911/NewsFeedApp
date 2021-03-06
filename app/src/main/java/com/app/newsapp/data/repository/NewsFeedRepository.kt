package com.app.newsapp.data.repository

import com.app.newsapp.data.model.NewsFeedResponse
import com.app.newsapp.web.ApiService
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Pranav Bhoraskar
 *
 * Repository Class - acts as a bridge between data/api calls and rest of the app
 */
class NewsFeedRepository @Inject constructor(private val apiService: ApiService) {
    fun fetchNewsFeed(): Observable<NewsFeedResponse> {
        return apiService.fetchNewsFeed()
    }
}