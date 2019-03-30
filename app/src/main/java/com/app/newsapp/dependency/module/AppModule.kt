package com.app.newsapp.dependency.module

import android.app.Application
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton


const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"

/**
 * @author Pranav Bhoraskar
 *
 * Class that provides Dagger Module to the application
 *
 * @param android.app.Application application
 *
 * @see     <a href="https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2">
 *          Dependency Injection with Dagger 2</a>
 */

@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Application = application

    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    fun provideAndroidMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(SCHEDULER_IO)
    fun provideIoScheduler(): Scheduler = Schedulers.io()
}