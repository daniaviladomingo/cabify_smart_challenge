package com.cabify.smart.challenge.di.application.module

import com.cabify.smart.challenge.schedulers.IScheduleProvider
import dagger.Module
import dagger.Provides
import eu.electronicid.demo.schedulers.ScheduleProviderImp
import javax.inject.Singleton

@Module
class SchedulerModule {
    @Provides
    @Singleton
    fun provideScheduleProvider(): IScheduleProvider = ScheduleProviderImp()

    interface Exposes {
        fun schedule(): IScheduleProvider
    }
}