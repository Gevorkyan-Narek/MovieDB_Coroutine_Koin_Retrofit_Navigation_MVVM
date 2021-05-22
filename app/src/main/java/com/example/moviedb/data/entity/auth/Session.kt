package com.example.moviedb.data.entity.auth

import com.squareup.moshi.Json

data class Session(
    val success: Boolean,
    @Json(name = "session_id")
    val sessionId: String
)
