package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.data.remote.model.DataProduct
import com.cabify.smart.challenge.data.remote.model.DataProducts
import com.cabify.smart.challenge.data.remote.model.mapper.DataMapper
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    @Singleton
    fun provideSmsRequestMapper(): Mapper<DataProduct, Product> = DataMapper()
}