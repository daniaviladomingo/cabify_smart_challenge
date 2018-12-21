package com.cabify.smart.challenge.ui.main

import com.cabify.smart.challenge.base.BaseViewModel
import com.cabify.smart.challenge.domain.interactor.AddProductUseCase
import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.domain.interactor.RemoveProductUseCase
import com.cabify.smart.challenge.schedulers.IScheduleProvider

class MainActivityViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val addProductUseCase: AddProductUseCase,
    private val removeProductUseCase: RemoveProductUseCase,
    private val scheduleProvider: IScheduleProvider
) : BaseViewModel() {


}