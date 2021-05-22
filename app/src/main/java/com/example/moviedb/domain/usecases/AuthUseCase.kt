package com.example.moviedb.domain.repository

import com.example.moviedb.data.api.AuthApi
import com.example.moviedb.data.entity.auth.RequestToken
import com.example.moviedb.data.entity.auth.Session
import kotlinx.coroutines.flow.Flow

class AuthUseCase(private val authApi: AuthApi) {

    companion object {
        private const val BASE_API_KEY = "7a00b045a944e9396f766b8e2b906775"
    }

    fun createRequestToken(): Flow<RequestToken> = authApi.createRequestToken(BASE_API_KEY)
    fun createSession(apiKey: String): Flow<Session> = authApi.createSession(apiKey)
}