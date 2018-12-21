package com.cabify.smart.challenge.di.activity.module

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import com.cabify.smart.challenge.di.activity.ActivityScope
import com.cabify.smart.challenge.di.activity.DaggerActivity
import com.cabify.smart.challenge.di.activity.ForActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val daggerActivity: DaggerActivity) {

    @Provides
    @ActivityScope
    @ForActivity
    fun provideContext(): Context = daggerActivity

    @Provides
    @ActivityScope
    fun provideActivity(): Activity = daggerActivity

    @Provides
    @ActivityScope
    fun provideFragmentManager(): FragmentManager = daggerActivity.supportFragmentManager

    interface Exposes {
        @ForActivity
        fun context(): Context

        fun activity(): Activity
    }
}