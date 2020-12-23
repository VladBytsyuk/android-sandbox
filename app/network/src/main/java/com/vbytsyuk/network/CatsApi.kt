package com.vbytsyuk.network

import retrofit2.http.GET


internal interface CatsApi {
    @GET("/breeds")
    suspend fun fetchBreedsList(): List<CatBreedResponse>
}
