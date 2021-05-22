package com.example.moviedb.ui.movie

import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment: Fragment() {

    private val movieViewModel: MovieViewModel by viewModel()
}