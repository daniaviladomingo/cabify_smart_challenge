package com.cabify.smart.challenge.di.application.module

import android.content.Context
import com.cabify.smart.challenge.R
import com.cabify.smart.challenge.di.application.FormatPrice
import com.cabify.smart.challenge.di.application.Money
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConfigModule {
    @Provides
    @Singleton
    @Money
    fun provideMoney(): String = "€"

    @Provides
    @Singleton
    @FormatPrice
    fun provideFormatPrice(context: Context): String = context.getString(R.string.format_price)
}