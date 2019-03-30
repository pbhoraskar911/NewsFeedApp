package com.app.newsapp.dependency.module

import com.app.newsapp.view.fragment.ErrorFragment
import com.app.newsapp.view.fragment.NewsFeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author Pranav Bhoraskar
 *
 */

@Module
abstract class FragmentInjectorModule {

    @ContributesAndroidInjector
    internal abstract fun injectNewsFeedFragment(): NewsFeedFragment

    @ContributesAndroidInjector
    internal abstract fun injectErrorFragment(): ErrorFragment
}