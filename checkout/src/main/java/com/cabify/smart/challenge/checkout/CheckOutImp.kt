package com.cabify.smart.challenge.checkout

import com.cabify.smart.challenge.domain.checkout.ICheckOut
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCode
import io.reactivex.Single

class CheckOutImp : ICheckOut {

    private val products = mutableMapOf<Product, Int>()

    private var tshirtCount = 0
    private var voucherCount = 0

    private var total = 0

    override fun addProduct(product: Product): Single<Int> = Single.create {
        total += product.price

        if (product.code == ProductCode.VOUCHER) {
            voucherCount++
            if (voucherCount == 2) {
                voucherCount = 0
                total -= product.price
            }
        }

        if (product.code == ProductCode.TSHIRT) {
            tshirtCount++
            if (tshirtCount == 3) {
                tshirtCount = 0
                total -= 3
            }
        }

        products[product] = products[product]?.plus(1) ?: 1

        it.onSuccess(total)
    }

    override fun removeProduct(product: Product): Single<Int> = Single.create {
        products[product]?.run {

            total -= product.price

            if (product.code == ProductCode.VOUCHER) {
                voucherCount--
                if (voucherCount == -2) {
                    voucherCount = 0
                    total += product.price
                }
            }

            if (product.code == ProductCode.TSHIRT) {
                tshirtCount--
                if (tshirtCount == -3) {
                    tshirtCount = 0
                    total += 3
                }
            }

            products[product] = this - 1
        }

        it.onSuccess(total)
    }
}