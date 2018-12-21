package com.cabify.smart.challenge.data

import com.cabify.smart.challenge.data.remote.IRemote
import com.cabify.smart.challenge.data.remote.model.Products
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.mapper.Mapper
import com.cabify.smart.challenge.domain.repository.IRepository
import io.reactivex.Single

class RepositoryImp(
    private val remote: IRemote,
    private val mapper: Mapper<Products, List<Product>>
) : IRepository {
    override fun getProducts(): Single<List<Product>> = remote.getProducts().map { mapper.map(it) }
}