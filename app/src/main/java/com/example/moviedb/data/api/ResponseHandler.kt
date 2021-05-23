package com.example.moviedb.data.api

import retrofit2.HttpException
import java.net.SocketTimeoutException

open class ResponseHandler {

    fun <T> handlerSuccess(data: T): Resource<T> = Resource.success(data)
    fun <T> handlerException(e: Exception): Resource<T> = when (e) {
        is HttpException -> Resource.error(getErrorMessage(e.code()))
        is SocketTimeoutException -> Resource.error(getErrorMessage(ErrorCodes.SocketTimedOut.code))
        else -> Resource.error(getErrorMessage(0))
    }

    private fun getErrorMessage(code: Int): String = when (code) {
        ErrorCodes.SocketTimedOut.code -> "Проверьте соединение с интернетом и попробуйте ещё раз"
        401 -> "Неверный логин или пароль"
        else -> "Что-то пошло не так, попробуйте позже"
    }

    private enum class ErrorCodes(val code: Int) {
        SocketTimedOut(-1)
    }
}