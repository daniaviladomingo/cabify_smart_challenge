package com.cabify.smart.challenge.data.remote.model.mapper

import com.cabify.smart.challenge.data.remote.model.Products
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper

class DataMapper : Mapper<Products, List<Product>>() {
    override fun map(model: Products): List<Product> = model.run { model.products }

    override fun inverseMap(model: List<Product>): Products {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}