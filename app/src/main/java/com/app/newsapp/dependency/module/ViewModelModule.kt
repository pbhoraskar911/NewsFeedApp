package com.app.newsapp.dependency.module

import androidx.lifecycle.ViewModel
import com.app.newsapp.viewmodels.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


/**
 * @author Pranav Bhoraskar
 *
 * Class provides View Model Dagger module to the application
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}