package com.example.moviedb.data.api

import com.example.moviedb.data.entity.movie.MovieResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("/movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ru-RU"
    ): Flow<MovieResponse>

    @GET("/movie/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ru-RU"
    ): Flow<MovieResponse>

    @GET("/movie/upcoming")
    fun getUpComing(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ru-RU"
    ): Flow<MovieResponse>

    @GET("/movie/{movie_id}")
    fun getDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ru-RU"
    ): Flow<MovieResponse>
}