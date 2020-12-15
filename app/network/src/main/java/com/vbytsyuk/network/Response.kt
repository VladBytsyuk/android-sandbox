package com.vbytsyuk.network


interface Response<Model> {
    fun toModel(): Model
}
