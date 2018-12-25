package com.cabify.smart.challenge.domain.checkout

import com.cabify.smart.challenge.domain.model.ProductCheckOut
import com.cabify.smart.challenge.domain.model.ProductCode
import io.reactivex.Single

interface ICheckOut {
    fun addProduct(productCode: ProductCode): Single<List<ProductCheckOut>>
    fun removeProduct(productCode: ProductCode): Single<List<ProductCheckOut>>
}