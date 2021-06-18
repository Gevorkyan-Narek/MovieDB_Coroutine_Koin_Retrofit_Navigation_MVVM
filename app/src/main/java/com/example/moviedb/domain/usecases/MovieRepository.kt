package com.example.moviedb.domain.usecases

import com.example.moviedb.data.api.MovieApi
import com.example.moviedb.data.api.Resource
import com.example.moviedb.data.api.ResponseHandler
import com.example.moviedb.data.entity.movie.Movie
import com.example.moviedb.data.entity.movie.MovieResponse

class MovieRepository(
    private val movieApi: MovieApi,
    private val responseHandler: ResponseHandler
) {

    suspend fun getPopular(): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getPopular())
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun getTopRated(): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getTopRated())
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun getUpComing(): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getUpComing())
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun getDetails(movieId: Long): Resource<Movie> = try {
        responseHandler.handlerSuccess(movieApi.getDetails(movieId))
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

}