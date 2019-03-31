package com.app.newsapp.dependency.module

import com.app.newsapp.view.activities.LauncherActivity
import com.app.newsapp.view.activities.MainActivity
import com.app.newsapp.view.activities.WebViewActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Pranav Bhoraskar
 *
 */

@Module
abstract class ActivityInjectorModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentInjectorModule::class))
    internal abstract fun injectMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun injectWebViewActivity(): WebViewActivity

    @ContributesAndroidInjector
    internal abstract fun injectLauncherActivity(): LauncherActivity
}