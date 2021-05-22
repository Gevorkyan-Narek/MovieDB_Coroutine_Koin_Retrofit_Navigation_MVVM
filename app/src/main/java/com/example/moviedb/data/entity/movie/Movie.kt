package com.example.moviedb.data.entity.movie

import com.squareup.moshi.Json

data class Movie (
    val title: String,
    val overview: String,
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String
)
