package com.cabify.smart.challenge.domain.model

enum class ProductCode constructor(val productCode: String) {
    VOUCHER("VOUCHER"),
    TSHIRT("TSHIRT"),
    MUG("MUG");

    companion object {
        fun valueFor(productCode: String): ProductCode = ProductCode.values().first { it.productCode == productCode }
    }
}