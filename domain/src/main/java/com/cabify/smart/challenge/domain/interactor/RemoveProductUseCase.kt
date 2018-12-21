package com.cabify.smart.challenge.domain.interactor

import com.cabify.smart.challenge.domain.checkout.ICheckOut
import com.cabify.smart.challenge.domain.interactor.type.SingleUseCaseWithParameter
import com.cabify.smart.challenge.domain.model.Product
import io.reactivex.Single

class RemoveProductUseCase(private val checkout: ICheckOut) : SingleUseCaseWithParameter<Product, Int> {
    override fun execute(parameter: Product): Single<Int> = checkout.removeProduct(parameter)
}