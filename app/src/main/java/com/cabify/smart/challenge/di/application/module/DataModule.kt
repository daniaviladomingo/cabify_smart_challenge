package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.data.RepositoryImp
import com.cabify.smart.challenge.data.cache.ICache
import com.cabify.smart.challenge.data.remote.IRemote
import com.cabify.smart.challenge.data.remote.model.RemoteProducts
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(
        dataRemote: IRemote,
        dataCache: ICache,
        dataMapper: Mapper<RemoteProducts, List<Product>>
    ): IRepository =
        RepositoryImp(
            dataRemote,
            dataCache,
            dataMapper
        )
}