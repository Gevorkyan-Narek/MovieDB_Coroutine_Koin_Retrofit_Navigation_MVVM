package com.example.moviedb.data.entity.auth

import com.squareup.moshi.Json

data class AuthResponse(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "expires_at")
    val expiresAt: String,
    @Json(name = "request_token")
    val requestToken: String
)
