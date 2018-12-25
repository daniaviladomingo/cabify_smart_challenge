package com.cabify.smart.challenge.data.cache.definition.typeconverter

import android.arch.persistence.room.TypeConverter
import com.cabify.smart.challenge.domain.model.ProductCode


class ProductTypeConverter {

    @TypeConverter
    fun toProductType(value: String): ProductCode = ProductCode.valueFor(value)

    @TypeConverter
    fun toString(value: ProductCode): String = value.productCode
}