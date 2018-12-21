package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetProductUseCase(repository: IRepository): GetProductsUseCase = GetProductsUseCase(repository)

    interface Exposes {

        fun getProductsUseCase(): GetProductsUseCase
    }
}