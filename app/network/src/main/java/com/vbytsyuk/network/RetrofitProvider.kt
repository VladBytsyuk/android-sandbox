package com.vbytsyuk.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal class RetrofitProvider(private val url: String) {
    inline fun <reified T> create(): T = createRetrofit().create(T::class.java)
    
    private fun createRetrofit() = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
}
