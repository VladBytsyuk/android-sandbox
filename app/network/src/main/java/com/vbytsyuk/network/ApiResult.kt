package com.vbytsyuk.network


sealed class ApiResult<out T : Any> {
    sealed class Received<out T : Any> : ApiResult<T>() {
        data class Content<out T : Any>(val content: T) : Received<T>()
        data class Error(val code: Int, val description: String, val message: String?) : Received<Nothing>()
    }
    data class Failure(val throwable: Throwable) : ApiResult<Nothing>()
}
