package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.domain.checkout.ICheckOut
import com.cabify.smart.challenge.domain.interactor.AddProductUseCase
import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.domain.interactor.RemoveProductUseCase
import com.cabify.smart.challenge.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetProductUseCase(repository: IRepository): GetProductsUseCase = GetProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideAddProductUseCase(checkout: ICheckOut): AddProductUseCase = AddProductUseCase(checkout)

    @Provides
    @Singleton
    fun provideRemoveProductUseCase(checkout: ICheckOut): RemoveProductUseCase = RemoveProductUseCase(checkout)

    interface Exposes {

        fun getProductsUseCase(): GetProductsUseCase

        fun addProductUseCase(): AddProductUseCase

        fun removeProductUseCase(): RemoveProductUseCase
    }
}