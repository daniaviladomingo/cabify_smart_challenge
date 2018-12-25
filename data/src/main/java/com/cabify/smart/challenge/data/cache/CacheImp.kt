package com.cabify.smart.challenge.data.cache

import com.cabify.smart.challenge.data.cache.definition.AppDatabase
import com.cabify.smart.challenge.data.cache.model.ProductDb
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCode
import com.cabify.smart.challenge.domain.model.mapper.Mapper

class CacheImp(
    private val appDatabase: AppDatabase,
    private val mapper: Mapper<ProductDb, Product>
) : ICache {
    override fun getProduct(productCode: ProductCode): Product =
        mapper.map(appDatabase.productDao().getProduct(productCode))

    override fun addProducts(products: List<Product>) {
        products.forEach { product ->
            appDatabase.productDao().insert(mapper.inverseMap(product))
        }
    }
}