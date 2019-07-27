package com.app.newsapp.web

import com.app.newsapp.BuildConfig
import com.app.newsapp.application.NewsFeedApplication
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author Pranav Bhoraskar
 *
 * Class provides different instances of components required for making network calls
 */

object WebInjector {

    fun getCacheDir(): File {
        return NewsFeedApplication.component.getApplicationContext().cacheDir
    }

    val cacheSize: Long = 20 * 1024 * 1024 // 20 MB
    var cache = Cache(getCacheDir(), cacheSize)


    /**
     * Method to provide Retrofit instance
     *
     * @return Retrofit
     */
    fun getRetrofit(apiBaseUrl: String): Retrofit {
        val httpClient = getOkHttpClient()
        return Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    /**
     * Method provides OkHttpClient
     *
     * @return OkHttpClient
     */
    fun getOkHttpClient(): OkHttpClient {

        val builder = OkHttpClient.Builder()
        builder
            .addInterceptor(NetworkCallInterceptor())
            .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)

        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        builder.addInterceptor(httpLoggingInterceptor)
        return builder.build()
    }

    /**
     * Method provides the APIService instance
     *
     * @return APIService
     */
    fun provideApiService(apiBaseUrl: String): ApiService {
        return getRetrofit(apiBaseUrl).create(ApiService::class.java)
    }
}