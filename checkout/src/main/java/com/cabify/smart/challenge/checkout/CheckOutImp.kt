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

    override fun addProduct(productCode: ProductCode): Single<List<ProductCheckOut>> = Single.create { emitter ->
        val product = dataCache.getProduct(productCode)

        products.add(products.find { it.code == productCode }?.apply { units++ } ?: ProductCheckOut(
            product.code,
            product.name,
            product.price,
            0,
            0
        ))

        calculateDiscount()
        emitter.onSuccess(products)
    }

    override fun removeProduct(productCode: ProductCode): Single<List<ProductCheckOut>> = Single.create { emitter ->

        products.find { it.code == productCode }?.run {
            units--
        }

        calculateDiscount()
        emitter.onSuccess(products)
    }

    private fun calculateDiscount() {
        products.forEach { product ->
            when (product.code) {
                ProductCode.VOUCHER -> {
                    product.discount = (product.units / 2) * product.price
                }
                ProductCode.TSHIRT -> {
                    product.discount = (product.units / 3) * 3
                }
                else -> {
                }
            }
        }
    }
}