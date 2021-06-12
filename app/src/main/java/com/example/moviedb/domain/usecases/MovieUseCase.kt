package com.example.moviedb.domain.usecases

import com.example.moviedb.data.api.MovieApi
import com.example.moviedb.data.api.Resource
import com.example.moviedb.data.api.ResponseHandler
import com.example.moviedb.data.entity.movie.MovieResponse

class MovieUseCase(
    private val movieApi: MovieApi,
    private val responseHandler: ResponseHandler
) : BaseUseCase() {

    suspend fun getPopular(): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getPopular(BASE_API_KEY))
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun getTopRated(): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getTopRated(BASE_API_KEY))
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun getUpComing(): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getUpComing(BASE_API_KEY))
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

    suspend fun getDetails(movieId: Int): Resource<MovieResponse> = try {
        responseHandler.handlerSuccess(movieApi.getDetails(movieId, BASE_API_KEY))
    } catch (e: Exception) {
        responseHandler.handlerException(e)
    }

}