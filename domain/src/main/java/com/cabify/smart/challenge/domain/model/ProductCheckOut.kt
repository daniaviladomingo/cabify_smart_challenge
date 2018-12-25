package com.cabify.smart.challenge.domain.model

data class ProductCheckOut(
    val name: String,
    val price: Int,
    var units: Int,
    var discount: Int
)