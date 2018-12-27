package com.cabify.smart.challenge.data.cache.model.mapper

import com.cabify.smart.challenge.data.cache.model.ProductDb
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper

class CacheMapper : Mapper<ProductDb, Product>() {
    override fun map(model: ProductDb): Product = model.run {
        Product(code, name, price)
    }

    override fun inverseMap(model: Product): ProductDb {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}