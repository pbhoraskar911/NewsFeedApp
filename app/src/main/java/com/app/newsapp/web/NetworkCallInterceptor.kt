package com.app.newsapp.web

import com.app.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Pranav Bhoraskar
 *
 * Interceptor class to intercept the api call being made and add necessary data to the request url
 */
class NetworkCallInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val url =
            request.url().newBuilder()
                .addQueryParameter("apiKey", BuildConfig.API_KEY)
                .build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}