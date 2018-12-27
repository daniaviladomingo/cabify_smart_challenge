package com.cabify.smart.challenge.di.application

import com.cabify.smart.challenge.AppApplication
import com.cabify.smart.challenge.di.application.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        DataCacheModule::class,
        DataModule::class,
        DataRemoteModule::class,
        MapperModule::class,
        SchedulerModule::class,
        UseCaseModule::class]
)

interface ApplicationComponent : ApplicationComponentExposes {

    companion object {
        fun init(appApplication: AppApplication): ApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(appApplication))
            .build()
    }
}