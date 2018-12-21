package com.cabify.smart.challenge.ui.main

import com.cabify.smart.challenge.base.BaseViewModel
import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.schedulers.IScheduleProvider

class MainActivityViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val scheduleProvider: IScheduleProvider
) : BaseViewModel() {
}