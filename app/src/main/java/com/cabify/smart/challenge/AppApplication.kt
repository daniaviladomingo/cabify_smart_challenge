package com.cabify.smart.challenge

import android.app.Application
import com.cabify.smart.challenge.di.createApplicationComponent
import com.cabify.smart.challenge.di.application.ApplicationComponent

class AppApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = createApplicationComponent(this)
    }
}