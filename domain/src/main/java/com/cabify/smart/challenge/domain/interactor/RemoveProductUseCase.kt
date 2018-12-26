package com.cabify.smart.challenge.domain.interactor

import com.cabify.smart.challenge.domain.checkout.ICheckOut
import com.cabify.smart.challenge.domain.interactor.type.SingleUseCaseWithParameter
import com.cabify.smart.challenge.domain.model.Product
import com.cabify.smart.challenge.domain.model.ProductCheckOut
import com.cabify.smart.challenge.domain.model.ProductCode
import io.reactivex.Single

class RemoveProductUseCase(private val checkout: ICheckOut) :
    SingleUseCaseWithParameter<ProductCode, List<ProductCheckOut>> {
    override fun execute(parameter: ProductCode): Single<List<ProductCheckOut>> = checkout.removeProduct(parameter)
}