package com.cabify.smart.challenge.di.application

import com.cabify.smart.challenge.di.application.module.ApplicationModule
import com.cabify.smart.challenge.di.application.module.SchedulerModule
import com.cabify.smart.challenge.di.application.module.UseCaseModule

interface ApplicationComponentExposes :
        ApplicationModule.Exposes,
        SchedulerModule.Exposes,
        UseCaseModule.Exposes
