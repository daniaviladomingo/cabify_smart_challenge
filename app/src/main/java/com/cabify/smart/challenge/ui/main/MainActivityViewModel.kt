package com.cabify.smart.challenge.ui.main

import com.cabify.smart.challenge.base.BaseViewModel
import com.cabify.smart.challenge.domain.interactor.AddProductUseCase
import com.cabify.smart.challenge.domain.interactor.GetProductsUseCase
import com.cabify.smart.challenge.domain.interactor.RemoveProductUseCase
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCheckOut
import com.cabify.smart.challenge.domain.model.ProductCode
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.schedulers.IScheduleProvider
import com.cabify.smart.challenge.ui.SingleLiveEvent
import com.cabify.smart.challenge.ui.data.Resource
import com.cabify.smart.challenge.ui.model.ProductView

class MainActivityViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val addProductUseCase: AddProductUseCase,
    private val removeProductUseCase: RemoveProductUseCase,
    private val scheduleProvider: IScheduleProvider,
) : BaseViewModel() {

    var getProductsLiveData = SingleLiveEvent<Resource<List<ProductView>>>()
    var checkoutProductsLiveData = SingleLiveEvent<Resource<List<ProductCheckOut>>>()

    fun getProducts() {
        getProductsLiveData.value = Resource.loading()
        addDisposable(getProductsUseCase.execute()
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ products ->
                getProductsLiveData.value = Resource.success(productMapper.map(products))
            }) {
                getProductsLiveData.value = Resource.error(it.localizedMessage)
            })
    }

    fun addProductToCheckout(productCode: ProductCode){
        checkoutProductsLiveData.value = Resource.loading()
        addDisposable(addProductUseCase.execute(productCode)
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ products ->
                checkoutProductsLiveData.value = Resource.success(products)
            }) {
                checkoutProductsLiveData.value = Resource.error(it.localizedMessage)
            })
    }

    fun removeProductToCheckout(productCode: ProductCode){
        checkoutProductsLiveData.value = Resource.loading()
        addDisposable(removeProductUseCase.execute(productCode)
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ products ->
                checkoutProductsLiveData.value = Resource.success(products)
            }) {
                checkoutProductsLiveData.value = Resource.error(it.localizedMessage)
            })
    }
}