package com.example.moviedb.ui.movie.search

import com.example.moviedb.databinding.FMovieSearchBinding
import com.example.moviedb.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieSearchFragment : BaseFragment() {

    override val viewModel: MovieSearchViewModel by viewModel()
    override val binding by lazy { FMovieSearchBinding.inflate(layoutInflater) }

    override fun observeViewModel() {

    }

    override fun prepare() {

    }
}