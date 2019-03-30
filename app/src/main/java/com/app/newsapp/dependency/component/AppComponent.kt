package com.app.newsapp.dependency.component

import android.app.Application
import com.app.newsapp.NewsFeedApplication
import com.app.newsapp.dependency.module.ActivityInjectorModule
import com.app.newsapp.dependency.module.AppModule
import com.app.newsapp.dependency.module.FragmentInjectorModule
import com.app.newsapp.dependency.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * @author Pranav Bhoraskar
 *
 * Interface that provide Dagger component injection
 * @see     <a href="https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2">
 *          Dependency Injection with Dagger 2</a>
 */
@Singleton
@Component(
    modules = arrayOf(
        AppModule::class, NetworkModule::class, AndroidInjectionModule::class, ActivityInjectorModule::class,
        FragmentInjectorModule::class
    )
)
interface AppComponent {

    fun injectApplication(newsFeedApplication: NewsFeedApplication)
    fun getApplicationContext(): Application
}