package com.cabify.smart.challenge.di.activity

import com.cabify.smart.challenge.di.activity.module.ActivityModule
import com.cabify.smart.challenge.di.activity.module.ViewModelFactoryModule
import com.cabify.smart.challenge.di.activity.module.ViewModelModule
import com.cabify.smart.challenge.di.application.ApplicationComponent
import com.cabify.smart.challenge.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        ActivityModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)

interface ActivityComponent : ActivityComponentExposes {

    fun inject(mainActivity: MainActivity)

    companion object {
        fun init(daggerActivity: DaggerActivity, applicationComponent: ApplicationComponent): ActivityComponent =
            DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(daggerActivity))
                .build()
    }
}