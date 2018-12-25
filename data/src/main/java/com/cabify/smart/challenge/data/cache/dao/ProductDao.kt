package com.cabify.smart.challenge.data.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.cabify.smart.challenge.data.cache.model.ProductDb
import com.cabify.smart.challenge.domain.model.ProductCode

@Dao
abstract class ProductDao : BaseDao<ProductDb> {

    @Query("SELECT * FROM code WHERE code = :code")
    abstract fun getProduct(code: ProductCode): ProductDb
}