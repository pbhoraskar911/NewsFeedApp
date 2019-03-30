package com.app.newsapp.dependency.module

import com.app.newsapp.web.ApiService
import com.app.newsapp.web.WebInjector
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * @author Pranav Bhoraskar
 *
 * Class provides network functionality module to the application
 *
 * @param apiBaseUrl  String
 *
 * @see     <a href="https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2">
 *          Dependency Injection with Dagger 2</a>
 */
@Module
class NetworkModule(private val apiBaseUrl: String) {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = WebInjector.getRetrofit(apiBaseUrl)

    @Singleton
    @Provides
    fun providesAPIService(): ApiService = WebInjector.provideApiService(apiBaseUrl)
}