package com.example.moviedb.ui.movie.top_rate

import android.widget.Toast
import com.example.moviedb.data.observe
import com.example.moviedb.data.setItemDecorationMargin
import com.example.moviedb.databinding.FTopMoviesBinding
import com.example.moviedb.ui.BaseFragment
import com.example.moviedb.ui.movie.MovieAdapter
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
            observe(errorTopRate) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
            observe(errorUpComing) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
            observe(movieUpComingList) {
                binding.recyclerUpComing.adapter = MovieAdapter(it, viewModel::onClickMovie)
            }
        }
    }

    override fun prepare() {
        binding.recyclerUpComing.setItemDecorationMargin(MARGIN_BETWEEN_RECYCLER_ITEMS)
        binding.recyclerTopFilms.setItemDecorationMargin(MARGIN_BETWEEN_RECYCLER_ITEMS)
    }
}