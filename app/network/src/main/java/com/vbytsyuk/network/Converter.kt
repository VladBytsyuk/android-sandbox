package com.vbytsyuk.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException


suspend fun <M : Any, R : Response<M>> requestJsonObject(
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

suspend fun <M : Any, R : Response<M>> requestJsonArray(
    block: suspend () -> List<R>
): ApiResult<List<M>> =
    try {
        val response = withContext(Dispatchers.IO) { block() }
        ApiResult.Received.Content(response.map { it.toModel() })
    } catch (httpException: HttpException) {
        ApiResult.Received.Error(
            code = httpException.code(),
            description = httpException.message(),
            message = httpException.response()?.errorBody()?.string()
        )
    } catch (throwable: Throwable) {
        ApiResult.Failure(throwable)
    }
