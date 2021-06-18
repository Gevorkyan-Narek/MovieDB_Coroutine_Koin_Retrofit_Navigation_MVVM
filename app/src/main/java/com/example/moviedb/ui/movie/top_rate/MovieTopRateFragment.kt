package com.example.moviedb.ui.movie.top_rate

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.moviedb.R
import com.example.moviedb.data.observe
import com.example.moviedb.data.setItemDecorationMarginRight
import com.example.moviedb.databinding.FTopMoviesBinding
import com.example.moviedb.ui.BaseFragment
import com.example.moviedb.ui.movie.MovieAdapter
import com.example.moviedb.ui.movie.detail.MovieDetailFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieTopRateFragment : BaseFragment() {

    companion object {
        private const val MARGIN_BETWEEN_RECYCLER_ITEMS = 15
    }

    override val viewModel: MovieTopRateViewModel by viewModel()
    override val binding by lazy { FTopMoviesBinding.inflate(layoutInflater) }

    override fun observeViewModel() {
        viewModel.run {
            observe(movieTopRateList) {
                binding.recyclerTopFilms.adapter = MovieAdapter(it, viewModel::onClickMovie)
            }
            observe(movieUpComingList) {
                binding.recyclerUpComing.adapter = MovieAdapter(it, viewModel::onClickMovie)
            }
            observe(errorTopRate) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
            observe(errorUpComing) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
            observe(onMovieClick) {
                findNavController().navigate(
                    R.id.movieDetailFragment,
                    MovieDetailFragment.createBundle(it)
                )
            }
        }
    }

    override fun prepare() {
        binding.recyclerUpComing.setItemDecorationMarginRight(MARGIN_BETWEEN_RECYCLER_ITEMS)
        binding.recyclerTopFilms.setItemDecorationMarginRight(MARGIN_BETWEEN_RECYCLER_ITEMS)
    }
}