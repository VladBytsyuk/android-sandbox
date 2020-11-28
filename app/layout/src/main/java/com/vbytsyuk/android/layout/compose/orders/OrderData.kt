package com.vbytsyuk.android.layout.compose.orders


sealed class OrderData {
    data class Successful(val number: Int) : OrderData()
    object Returned : OrderData()
    object Discount : OrderData()
}
