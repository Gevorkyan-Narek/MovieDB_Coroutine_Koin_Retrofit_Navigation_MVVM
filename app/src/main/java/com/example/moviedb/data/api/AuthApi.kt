package com.example.moviedb.data.api

import com.example.moviedb.data.entity.auth.AuthResponse
import retrofit2.http.*

interface AuthApi {

    @GET("authentication/token/new")
    suspend fun createRequestToken(@Query("api_key") apiKey: String): AuthResponse

    @FormUrlEncoded
    @POST("authentication/token/validate_with_login")
    suspend fun createSession(
        @Query("api_key") apiKey: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("request_token") requestToken: String
    ): AuthResponse
}