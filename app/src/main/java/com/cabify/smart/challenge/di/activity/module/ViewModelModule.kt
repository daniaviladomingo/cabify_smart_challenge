package com.cabify.smart.challenge.di.activity.module

import android.arch.lifecycle.ViewModel
import com.cabify.smart.challenge.ui.main.MainActivityViewModel
import com.cabify.smart.challenge.di.activity.ActivityScope
import com.cabify.smart.challenge.di.activity.ViewModelKey
import com.cabify.smart.challenge.domain.interactor.AddProductUseCase
import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.domain.interactor.RemoveProductUseCase
import com.cabify.smart.challenge.schedulers.IScheduleProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @Provides
    @ActivityScope
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun provideMainActivityViewModel(
        getProductsUseCase: GetProductsUseCase,
        scheduleProvider: IScheduleProvider,
        addProductUseCase: AddProductUseCase,
        removeProductUseCase: RemoveProductUseCase
    ): ViewModel = MainActivityViewModel(
        getProductsUseCase,
        addProductUseCase,
        removeProductUseCase,
        scheduleProvider
    )
}