package com.cabify.smart.challenge.data.remote

import com.cabify.smart.challenge.data.remote.model.DataProducts
import io.reactivex.Single
import retrofit2.http.GET

interface IRemote {
    @GET("bins/4bwec")
    fun getProducts(): Single<DataProducts>
}