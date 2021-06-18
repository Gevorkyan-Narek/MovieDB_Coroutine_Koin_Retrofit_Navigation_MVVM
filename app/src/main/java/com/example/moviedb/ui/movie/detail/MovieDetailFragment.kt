package com.example.moviedb.ui.movie.detail

import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import com.example.moviedb.data.api.setImage
import com.example.moviedb.data.observe
import com.example.moviedb.data.setItemDecorationMarginRight
import com.example.moviedb.databinding.FMovieDetailBinding
import com.example.moviedb.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : BaseFragment() {

    companion object {
        const val MOVIE_ID = "movie_id"
        fun createBundle(movieId: Long) = bundleOf(MOVIE_ID to movieId)
    }

    override val viewModel: MovieDetailViewModel by viewModel()
    override val binding by lazy { FMovieDetailBinding.inflate(layoutInflater) }

    override fun observeViewModel() {
        viewModel.run {
            observe(movie) {
                binding.title.text = it.title
                binding.description.text = it.overview
                binding.poster.setImage(it.posterBackground)
                binding.voteAverage.text = it.voteAverage.toString()
                if (!it.genres.isNullOrEmpty()) {
                    binding.genres.adapter = GenreAdapter(it.genres.map { genres -> genres.name })
                    binding.genres.setItemDecorationMarginRight(10)
                    binding.genres.isVisible = true
                } else {
                    binding.genres.isVisible = false
                }
            }
        }
    }



    override fun prepare() {
        arguments?.let {
            viewModel.onInit(it.getLong(MOVIE_ID, MovieDetailViewModel.NO_MOVIE_ID))
        }
    }
}