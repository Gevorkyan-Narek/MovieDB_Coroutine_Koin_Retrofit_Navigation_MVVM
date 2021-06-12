package com.example.moviedb.ui.movie.top_rate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.api.ResponseStatuses
import com.example.moviedb.data.entity.movie.Movie
import com.example.moviedb.domain.usecases.MovieUseCase
import kotlinx.coroutines.launch

class MovieTopRateViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _movieTopRateList = MutableLiveData<List<Movie>>()
    val movieTopRateList = _movieTopRateList

    private val _errorTopRate = MutableLiveData<String>()
    val errorTopRate = MutableLiveData<String>()

    private val _movieUpComingList = MutableLiveData<List<Movie>>()
    val movieUpComingList = _movieUpComingList

    private val _errorUpComing = MutableLiveData<String>()
    val errorUpComing = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            movieUseCase.getTopRated().apply {
                if (status == ResponseStatuses.SUCCESS && data != null) {
                    _movieTopRateList.value = data.movieList
                } else {
                    _errorTopRate.value = msg
                }
            }
            movieUseCase.getUpComing().apply {
                if (status == ResponseStatuses.SUCCESS && data != null) {
                    _movieUpComingList.value = data.movieList
                } else {
                    _errorUpComing.value = msg
                }

            }
        }
    }

    fun onClickMovie(id: Long) {

    }
}
