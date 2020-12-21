package com.vbytsyuk.network

import retrofit2.http.GET


interface CatsApi {
    @GET("/breeds")
    suspend fun fetchBreedsList(): List<CatBreedResponse>
}
