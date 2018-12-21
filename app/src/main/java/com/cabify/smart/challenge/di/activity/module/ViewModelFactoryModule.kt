package com.cabify.smart.challenge.di.activity.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.cabify.smart.challenge.di.activity.ActivityScope
import com.cabify.smart.challenge.ui.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ViewModelFactoryModule {
    @Provides
    @ActivityScope
    fun provideViewModelFactory(viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory =
        ViewModelFactory(viewModelsMap)
}