package com.vbytsyuk.network


class Api {
    private val catsApi: CatsApi = RetrofitProvider(url = "https://api.thecatapi.com/v1").create()

    suspend fun fetchCatBreedsList(): ApiResult<List<CatBreed>> = requestJsonArray { catsApi.fetchBreedsList() }
}
