package com.cabify.smart.challenge.ui.model.mapper

import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.ui.model.ProductView

class ProductViewMapper : Mapper<Product, ProductView>() {
    override fun map(model: Product): ProductView = model.run {
        ProductView(name, price =)
    }

    override fun inverseMap(model: ProductView): Product {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}