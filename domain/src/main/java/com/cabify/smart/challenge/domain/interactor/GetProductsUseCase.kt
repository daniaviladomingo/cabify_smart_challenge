package com.cabify.smart.challenge.domain.interactor

import com.cabify.smart.challenge.domain.interactor.type.SingleUseCase
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.repository.IRepository
import io.reactivex.Single

class GetProductsUseCase(private val repository: IRepository) : SingleUseCase<List<Product>> {
    override fun execute(): Single<List<Product>> = repository.getProducts()
}