package com.cabify.smart.challenge.di.activity

import com.cabify.smart.challenge.di.activity.module.ActivityModule
import com.cabify.smart.challenge.di.application.ApplicationComponentExposes

interface ActivityComponentExposes :
        ApplicationComponentExposes,
        ActivityModule.Exposes