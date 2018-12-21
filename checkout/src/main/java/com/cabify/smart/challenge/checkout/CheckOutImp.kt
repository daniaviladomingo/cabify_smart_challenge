package com.cabify.smart.challenge.checkout

import com.cabify.smart.challenge.domain.checkout.ICheckOut
import com.cabify.smart.challenge.domain.model.Product
import io.reactivex.Single

class CheckOutImp : ICheckOut {
    private val products = HashMap<Product, Int>()
    private var totalAmount = 0

    override fun addProduct(product: Product): Single<List<Product>> = Single.create {
    }

    override fun removeProduct(code: String): Single<List<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}