package com.app.newsapp

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.app.newsapp.dependency.component.AppComponent
import com.app.newsapp.dependency.component.DaggerAppComponent
import com.app.newsapp.dependency.module.AppModule
import com.app.newsapp.dependency.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Pranav Bhoraskar
 */
class NewsFeedApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingAndroidFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidActivityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidFragmentInjector

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(BuildConfig.API_BASE_URL))
            .build()
        return component.injectApplication(this)
    }
}