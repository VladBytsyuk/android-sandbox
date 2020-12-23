package com.vbytsyuk.network


internal interface Response<Model> {
    fun toModel(): Model
}
