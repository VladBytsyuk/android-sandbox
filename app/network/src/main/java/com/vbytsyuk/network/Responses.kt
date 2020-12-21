package com.vbytsyuk.network

import com.google.gson.annotations.SerializedName


data class CatBreedResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("temperament") val temperament: String,
    @SerializedName("life_span") val lifeSpan: String,
    @SerializedName("alt_names") val alternativeNames: String,
    @SerializedName("wikipedia_url") val wikipediaUrl: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("weight_imperial") val weightImperial: String,
) : Response<CatBreed> {
    override fun toModel() =
        CatBreed(id, name, temperament, lifeSpan, alternativeNames, wikipediaUrl, origin, weightImperial)
}
