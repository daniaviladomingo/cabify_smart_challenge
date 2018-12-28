package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.checkout.CheckOutImp
import com.cabify.smart.challenge.data.cache.ICache
import com.cabify.smart.challenge.domain.checkout.ICheckOut
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CheckOutModule {
    @Provides
    @Singleton
    fun provideCheckOut(dataCache: ICache): ICheckOut = CheckOutImp(dataCache)
}