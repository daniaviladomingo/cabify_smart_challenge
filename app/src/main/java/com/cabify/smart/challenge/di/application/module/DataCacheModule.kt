package com.cabify.smart.challenge.di.application.module

import android.arch.persistence.room.Room
import android.content.Context
import com.cabify.smart.challenge.data.cache.CacheImp
import com.cabify.smart.challenge.data.cache.ICache
import com.cabify.smart.challenge.data.cache.definition.AppDatabase
import com.cabify.smart.challenge.data.cache.model.ProductDb
import com.cabify.smart.challenge.di.application.DatabaseName
import com.cabify.smart.challenge.di.application.ForApplication
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataCacheModule {

    @Provides
    @Singleton
    fun provideDataCache(
        appDatabase: AppDatabase,
        mapper: Mapper<ProductDb, Product>
    ): ICache = CacheImp(appDatabase, mapper)

    @Provides
    @Singleton
    fun provideAppDatabase(@ForApplication context: Context, @DatabaseName databaseName: String): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, databaseName).allowMainThreadQueries().build()

    @Provides
    @Singleton
    @DatabaseName
    fun provideDatabaseName(): String = "cabify.challenge"
}