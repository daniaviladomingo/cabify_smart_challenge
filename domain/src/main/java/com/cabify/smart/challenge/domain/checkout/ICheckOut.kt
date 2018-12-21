package com.cabify.smart.challenge.domain.checkout

import com.cabify.smart.challenge.domain.model.Product
import io.reactivex.Single

interface ICheckOut {
    fun addProduct(product: Product): Single<List<Product>>
    fun removeProduct(code: String): Single<List<Product>>
}