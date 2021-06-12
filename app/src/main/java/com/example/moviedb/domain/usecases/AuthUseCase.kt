package com.example.moviedb.domain.usecases

import com.example.moviedb.data.api.AuthApi
import com.example.moviedb.data.api.Resource
import com.example.moviedb.data.api.ResponseHandler
import com.example.moviedb.data.entity.auth.AuthResponse

class AuthUseCase(
    private val authApi: AuthApi,
    private val responseHandler: ResponseHandler
) : BaseUseCase() {

    suspend fun createRequestToken(): Resource<AuthResponse> = try {
        responseHandler.handlerSuccess(authApi.createRequestToken(BASE_API_KEY))
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun createSession(
        login: String,
        password: String,
        requestToken: String
    ): Resource<AuthResponse> = try {
        responseHandler.handlerSuccess(
            authApi.createSession(
                BASE_API_KEY,
                login,
                password,
                requestToken
            )
        )
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }
}