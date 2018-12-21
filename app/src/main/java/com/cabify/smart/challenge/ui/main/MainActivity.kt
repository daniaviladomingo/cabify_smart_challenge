package com.cabify.smart.challenge.ui.main

import android.os.Bundle
import com.cabify.smart.challenge.R
import com.cabify.smart.challenge.base.BaseActivity
import com.cabify.smart.challenge.di.activity.ActivityComponent

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun checkAgain(): () -> Unit {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun tryAgain(): () -> Unit {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
