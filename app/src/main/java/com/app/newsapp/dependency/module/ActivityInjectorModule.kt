package com.app.newsapp.dependency.module

import com.app.newsapp.view.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Pranav Bhoraskar
 */

@Module
abstract class ActivityInjectorModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentInjectorModule::class))
    internal abstract fun injectMainActivity(): MainActivity
}