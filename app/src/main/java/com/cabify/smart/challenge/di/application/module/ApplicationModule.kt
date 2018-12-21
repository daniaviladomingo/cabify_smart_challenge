package com.cabify.smart.challenge.di.application.module

import android.app.Application
import android.content.Context
import com.cabify.smart.challenge.di.application.ForApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    @ForApplication
    internal fun provideContext(): Context {
        return application
    }

    interface Exposes {
        @ForApplication
        fun context(): Context
    }
}