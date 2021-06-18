package com.example.moviedb.data.api

import com.example.moviedb.data.entity.movie.Movie
import com.example.moviedb.data.entity.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String = BASE_API_KEY,
        @Query("language") language: String = "ru-RU"
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String = BASE_API_KEY,
        @Query("language") language: String = "ru-RU"
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpComing(
        @Query("api_key") apiKey: String = BASE_API_KEY,
        @Query("language") language: String = "ru-RU"
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String = BASE_API_KEY,
        @Query("language") language: String = "ru-RU"
    ): Movie
}