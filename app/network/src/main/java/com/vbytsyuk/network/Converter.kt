package com.vbytsyuk.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException


suspend fun <M : Any, R : Response<M>> makeApiCall(
    block: suspend () -> R
): ApiResult<M> =
    try {
        val response = withContext(Dispatchers.IO) { block() }
        ApiResult.Received.Content(response.toModel())
    } catch (httpException: HttpException) {
        ApiResult.Received.Error(
            code = httpException.code(),
            description = httpException.message(),
            message = httpException.response()?.errorBody()?.string()
        )
    } catch (throwable: Throwable) {
        ApiResult.Failure(throwable)
    }
