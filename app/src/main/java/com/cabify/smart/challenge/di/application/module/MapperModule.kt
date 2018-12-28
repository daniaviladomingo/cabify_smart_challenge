package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.data.cache.model.ProductDb
import com.cabify.smart.challenge.data.cache.model.mapper.CacheMapper
import com.cabify.smart.challenge.data.remote.model.RemoteProduct
import com.cabify.smart.challenge.data.remote.model.mapper.RemoteMapper
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.ui.model.ProductView
import com.cabify.smart.challenge.ui.model.mapper.ProductViewMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    @Singleton
    fun provideRemoteMapper(): Mapper<RemoteProduct, Product> = RemoteMapper()

    @Provides
    @Singleton
    fun provideCacheMapper(): Mapper<ProductDb, Product> = CacheMapper()

    @Provides
    @Singleton
    fun provideProductViewMapper(): Mapper<Product, ProductView> = ProductViewMapper()
}