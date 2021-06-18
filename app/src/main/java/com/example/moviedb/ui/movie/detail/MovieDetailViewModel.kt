package com.example.moviedb.ui.movie.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.api.ResponseStatuses
import com.example.moviedb.data.entity.movie.Movie
import com.example.moviedb.domain.usecases.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    companion object {
        const val NO_MOVIE_ID: Long = -1L
    }

    private val _movie = MutableLiveData<Movie>()
    val movie = _movie

    private val _movieNotFound = MutableLiveData<Unit>()
    val movieNotFound = _movieNotFound

    fun onInit(id: Long) {
        if (id != NO_MOVIE_ID)
            viewModelScope.launch(Dispatchers.IO) {
                movieRepository.getDetails(id).apply {
                    if (status == ResponseStatuses.SUCCESS) {
                        data?.let {
                            _movie.postValue(it)
                        }
                    } else {
                        _movieNotFound.postValue(Unit)
                    }
                }
            }
    }
}
