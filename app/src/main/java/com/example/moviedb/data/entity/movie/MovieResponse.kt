package com.example.moviedb.data.entity.movie

import com.squareup.moshi.Json

data class MovieResponse(
    val page: Int,
    @Json(name = "results")
    val movieList: List<Movie>
)
