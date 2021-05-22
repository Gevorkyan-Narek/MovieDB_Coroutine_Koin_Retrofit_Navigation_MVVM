package com.example.moviedb.domain.usecases

import com.example.moviedb.data.api.MovieApi
import com.example.moviedb.data.entity.movie.MovieResponse
import kotlinx.coroutines.flow.Flow

class MovieUseCase(private val movieApi: MovieApi) {

    fun getPopular(apiKey: String): Flow<MovieResponse> =
        movieApi.getPopular(apiKey)

    fun getTopRated(apiKey: String): Flow<MovieResponse> =
        movieApi.getTopRated(apiKey)

    fun getUpComing(apiKey: String): Flow<MovieResponse> =
        movieApi.getUpComing(apiKey)

    fun getDetails(movieId: Int, apiKey: String): Flow<MovieResponse> =
        movieApi.getDetails(movieId, apiKey)

}