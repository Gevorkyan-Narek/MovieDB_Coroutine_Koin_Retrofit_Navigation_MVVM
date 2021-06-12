package com.example.moviedb.ui.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviedb.databinding.FMovieContainerBinding
import com.example.moviedb.ui.BaseFragment
import com.example.moviedb.ui.movie.search.MovieSearchFragment
import com.example.moviedb.ui.movie.top_rate.MovieTopRateFragment

class MovieContainerFragment : BaseFragment() {
    override val viewModel: MovieContainerViewModel by viewModels()
    override val binding by lazy { FMovieContainerBinding.inflate(layoutInflater) }

    override fun observeViewModel() {

    }

    override fun prepare() {
        binding.viewPager.adapter = MoviePagerAdapter(childFragmentManager)
    }

    private inner class MoviePagerAdapter(fm: FragmentManager) :
        FragmentStateAdapter(fm, lifecycle) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> MovieSearchFragment()
            1 -> MovieTopRateFragment()
            else -> MovieSearchFragment()
        }
    }
}