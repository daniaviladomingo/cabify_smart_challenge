package com.cabify.smart.challenge.di

import com.cabify.smart.challenge.AppApplication
import com.cabify.smart.challenge.di.activity.ActivityComponent
import com.cabify.smart.challenge.di.activity.DaggerActivity
import com.cabify.smart.challenge.di.application.ApplicationComponent

fun createApplicationComponent(appApplication: AppApplication): ApplicationComponent =
    ApplicationComponent.init(appApplication)

fun createActivityComponent(daggerActivity: DaggerActivity, appApplication: AppApplication): ActivityComponent =
    ActivityComponent.init(daggerActivity, appApplication.applicationComponent)