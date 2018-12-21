package com.cabify.smart.challenge.data.remote.model.mapper

import com.cabify.smart.challenge.data.remote.model.DataProduct
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCode
import com.cabify.smart.challenge.domain.model.mapper.Mapper

class DataMapper : Mapper<DataProduct, Product>() {
    override fun map(model: DataProduct): Product = model.run {
        Product(ProductCode.valueFor(code), name, price)
    }

    override fun inverseMap(model: Product): DataProduct {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}