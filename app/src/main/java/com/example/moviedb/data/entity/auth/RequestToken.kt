package com.example.moviedb.data.entity.auth

import com.squareup.moshi.Json

data class RequestToken(
    val success: Boolean,
    @Json(name = "expires_at")
    val expiresAt: String,
    @Json(name = "request_token")
    val requestToken: String
)
