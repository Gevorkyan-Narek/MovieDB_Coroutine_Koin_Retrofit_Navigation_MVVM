package com.example.moviedb.data.api

import com.example.moviedb.data.entity.auth.RequestToken
import com.example.moviedb.data.entity.auth.Session
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {

    @GET("authentication/token/new")
    fun createRequestToken(@Query("api_key") apiKey: String): Flow<RequestToken>

    @GET("authentication/session/new")
    fun createSession(@Query("api_key") apiKey: String): Flow<Session>
}