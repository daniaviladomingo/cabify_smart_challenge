package com.cabify.smart.challenge.domain.repository

import com.cabify.smart.challenge.domain.model.Product
import io.reactivex.Single

interface IRepository {
    fun getProducts(): Single<List<Product>>
}