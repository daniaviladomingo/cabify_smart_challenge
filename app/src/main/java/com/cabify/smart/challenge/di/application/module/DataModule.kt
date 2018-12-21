package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.data.RepositoryImp
import com.cabify.smart.challenge.data.remote.IRemote
import com.cabify.smart.challenge.data.remote.model.DataProducts
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
    fun provideRepository(dataRemote: IRemote, dataMapper: Mapper<DataProducts, List<Product>>): IRepository =
        RepositoryImp(dataRemote, dataMapper)
}