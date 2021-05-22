package com.example.moviedb.data.entity.movie

data class MovieResponse(
    val page: Int,
    val movieList: List<Movie>
)
