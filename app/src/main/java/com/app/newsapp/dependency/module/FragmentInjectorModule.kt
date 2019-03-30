package com.app.newsapp.dependency.module

import com.app.newsapp.view.fragment.NewsFeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Pranav Bhoraskar
 */

@Module
abstract class FragmentInjectorModule {

    @ContributesAndroidInjector
    internal abstract fun injectNewsFeedFragment(): NewsFeedFragment
}