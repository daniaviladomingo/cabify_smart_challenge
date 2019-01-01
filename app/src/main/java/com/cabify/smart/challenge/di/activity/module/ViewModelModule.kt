package com.cabify.smart.challenge.di.activity.module

import android.arch.lifecycle.ViewModel
import com.cabify.smart.challenge.ui.main.MainActivityViewModel
import com.cabify.smart.challenge.di.activity.ActivityScope
import com.cabify.smart.challenge.di.activity.ViewModelKey
import com.cabify.smart.challenge.domain.interactor.AddProductUseCase
import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.domain.interactor.RemoveProductUseCase
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.schedulers.IScheduleProvider
import com.cabify.smart.challenge.ui.model.ProductView
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
        addProductUseCase: AddProductUseCase,
        removeProductUseCase: RemoveProductUseCase,
        scheduleProvider: IScheduleProvider,
        productMapper: Mapper<Product, ProductView>
    ): ViewModel = MainActivityViewModel(
        getProductsUseCase,
        addProductUseCase,
        removeProductUseCase,
        scheduleProvider,
        productMapper
    )
}