package com.cabify.smart.challenge.data.remote.model.mapper

import com.cabify.smart.challenge.data.remote.model.RemoteProduct
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCode
import com.cabify.smart.challenge.domain.model.mapper.Mapper

class RemoteMapper : Mapper<RemoteProduct, Product>() {
    override fun map(model: RemoteProduct): Product = model.run {
        Product(ProductCode.valueFor(code), name, price)
    }

    override fun inverseMap(model: Product): RemoteProduct {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}