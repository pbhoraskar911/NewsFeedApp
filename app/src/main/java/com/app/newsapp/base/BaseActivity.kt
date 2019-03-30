package com.app.newsapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity


/**
 * Created by Pranav Bhoraskar
 */
abstract class BaseActivity : DaggerAppCompatActivity() {
    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        ButterKnife.bind(this)
    }
}