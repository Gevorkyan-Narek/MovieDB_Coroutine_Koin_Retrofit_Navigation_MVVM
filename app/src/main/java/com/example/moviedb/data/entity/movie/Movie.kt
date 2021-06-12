package com.example.moviedb.data.entity.movie

import com.squareup.moshi.Json

data class Movie (
    val id: Long,
    val title: String,
    val overview: String,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "poster_path")
    val posterPath: String
)
