package com.app.newsapp.web

import com.app.newsapp.BuildConfig
import com.app.newsapp.NewsFeedApplication
import com.app.newsapp.utils.isConnectedToInternet
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Pranav Bhoraskar
 *
 * Interceptor class to intercept the api call being made and add necessary data to the request url
 */
class NetworkCallInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val context = NewsFeedApplication.component.getApplicationContext()
        var request = chain.request()

        val url = request.url().newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()

        request = if (context.isConnectedToInternet())
            request.newBuilder().header("Cache-Control", "public, max-age=" + 30).build()
        else
            request.newBuilder().header(
                "Cache-Control",
                "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
            ).build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}