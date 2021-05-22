package com.example.moviedb.data.api

import com.example.moviedb.data.entity.auth.RequestToken
import com.example.moviedb.data.entity.auth.Session
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface AuthApi {

    @GET("authentication/token/new")
    fun createRequestToken(@Query("api_key") apiKey: String): Flow<RequestToken>

    @POST("authentication/session/new")
    fun createSession(
        @Query("api_key") apiKey: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("request_token") requestToken: String
    ): Flow<Session>
}