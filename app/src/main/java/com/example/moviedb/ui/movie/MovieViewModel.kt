package com.example.moviedb.ui.movie

import androidx.lifecycle.ViewModel
import com.example.moviedb.domain.usecases.MovieUseCase

class MovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

}