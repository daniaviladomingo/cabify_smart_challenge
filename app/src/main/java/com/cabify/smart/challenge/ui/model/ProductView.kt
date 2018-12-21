package com.cabify.smart.challenge.ui.model

import com.cabify.smart.challenge.domain.model.ProductCode

data class ProductView(
    val code: ProductCode,
    val name: String,
    val price: Int,
    val units: Int
)