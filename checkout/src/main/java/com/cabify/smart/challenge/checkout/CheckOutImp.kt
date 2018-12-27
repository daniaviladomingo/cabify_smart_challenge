package com.cabify.smart.challenge.checkout

import com.cabify.smart.challenge.data.cache.ICache
import com.cabify.smart.challenge.domain.checkout.ICheckOut
import com.cabify.smart.challenge.domain.model.ProductCheckOut
import com.cabify.smart.challenge.domain.model.ProductCode
import io.reactivex.Single

class CheckOutImp(
    private val dataCache: ICache
) : ICheckOut {

    private val products = mutableListOf<ProductCheckOut>()

    override fun addProduct(productCode: ProductCode): Single<List<ProductCheckOut>> = Single.create {
        val product = dataCache.getProduct(productCode)



        it.onSuccess(products.values.toList())
    }

    override fun removeProduct(productCode: ProductCode): Single<List<ProductCheckOut>> = Single.create {
        val product = dataCache.getProduct(productCode)

        products[productCode]?.run {
            this.units--
            if (units == 0) {
                products.remove(productCode)
            }
        }

        it.onSuccess(products.values.toList())
    }

    private fun calculateDiscount() {

    }
}