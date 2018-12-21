package com.cabify.smart.challenge.domain.checkout

import com.cabify.smart.challenge.domain.model.Product
import io.reactivex.Single

interface ICheckOut {
    fun addProduct(product: Product): Single<Int>
    fun removeProduct(product: Product): Single<Int>
}