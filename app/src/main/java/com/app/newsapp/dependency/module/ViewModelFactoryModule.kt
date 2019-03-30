package com.app.newsapp.dependency.module

import androidx.lifecycle.ViewModelProvider
import com.app.newsapp.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module


/**
 * @author Pranav Bhoraskar
 *
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}