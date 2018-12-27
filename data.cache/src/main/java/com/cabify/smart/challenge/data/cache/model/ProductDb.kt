package com.cabify.smart.challenge.data.cache.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.cabify.smart.challenge.domain.model.ProductCode

@Entity(
    tableName = "product",
    indices = [Index(value = ["code"], unique = true)]
)

class ProductDb {
    @PrimaryKey
    @ColumnInfo(name = "code")
    lateinit var code: ProductCode

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "price")
    var price: Int = 0
}