package com.cabify.smart.challenge.di.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cabify.smart.challenge.AppApplication
import com.cabify.smart.challenge.di.createActivityComponent

abstract class DaggerActivity : AppCompatActivity() {

    private var activityComponent: ActivityComponent? = null
        get() = field ?: createActivityComponent(this, appApplication)

    private val appApplication: AppApplication
        get() = (application as AppApplication)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(activityComponent!!)
    }

    protected abstract fun inject(activityComponent: ActivityComponent)
}