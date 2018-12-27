package com.cabify.smart.challenge.data.cache

import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCode

interface ICache {
    fun getProduct(productCode: ProductCode): Product
    fun addProducts(products: List<Product>)
}