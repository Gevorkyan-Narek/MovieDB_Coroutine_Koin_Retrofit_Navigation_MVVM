package com.example.moviedb.data.api

import android.util.Log

data class Resource<out T>(
    val status: ResponseStatuses,
    val data: T?,
    val msg: String?
) {

    companion object {
        fun <T> success(data: T): Resource<T> = Resource(ResponseStatuses.SUCCESS, data, null)
        fun <T> error(msg: String): Resource<T> {
            Log.e("Response Error", msg)
            return Resource(ResponseStatuses.ERROR, null, msg)
        }
    }
}
