package com.cabify.smart.challenge.data.cache.definition

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.cabify.smart.challenge.data.cache.dao.ProductDao
import com.cabify.smart.challenge.data.cache.definition.typeconverter.ProductTypeConverter
import com.cabify.smart.challenge.data.cache.model.ProductDb


private const val DATABASE_VERSION = 1

@Database(
    entities = [
        ProductDb::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)

@TypeConverters(
    ProductTypeConverter::class
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}