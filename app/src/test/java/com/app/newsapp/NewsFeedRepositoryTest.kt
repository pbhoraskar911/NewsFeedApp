package com.app.newsapp

import com.app.newsapp.data.model.Articles
import com.app.newsapp.data.model.NewsFeedResponse
import com.app.newsapp.data.model.Source
import com.app.newsapp.web.ApiService
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito


/**
 * @author Pranav Bhoraskar
 */

@RunWith(JUnit4::class)
class NewsFeedRepositoryTest {

    private val retrofitService = Mockito.mock(ApiService::class.java)

    @Test
    fun getWeatherTest() {

        var apiResponse = successResponse()

        val queryMap = HashMap<String, String>()
        queryMap.put("country", "in")
        queryMap.put("category", "general")
        queryMap.put("apiKey", BuildConfig.API_KEY)

        Mockito.`when`(retrofitService.fetchNewsFeed(queryMap)).thenReturn(Observable.just(apiResponse))

    }

    private fun successResponse(): NewsFeedResponse? {
        var apiResponse = NewsFeedResponse()

        apiResponse.status = "ok"
        apiResponse.totalResults = 1
        apiResponse.articles = listOf(
            Articles(
                source = Source("", ""),
                author = "author",
                publishedAt = "publish",
                url = "url",
                title = "title",
                description = "desc",
                urlToImage = "url"
            )
        )

        return apiResponse
    }
}