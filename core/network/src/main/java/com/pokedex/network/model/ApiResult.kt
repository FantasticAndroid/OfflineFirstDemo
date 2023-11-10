package com.pokedex.network.model

sealed class ApiResult<T>(val data: T? = null, val errorCode: Int?= -1, val message: String? = null) {
    class Loading<T> : ApiResult<T>()

    class Success<T>(data: T) : ApiResult<T>(data = data)

    class Error<T>(errorCode: Int, message: String) : ApiResult<T>(message = message)
}
