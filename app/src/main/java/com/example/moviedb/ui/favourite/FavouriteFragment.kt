package com.example.moviedb.ui.favourite

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.moviedb.databinding.FFavouriteBinding
import com.example.moviedb.ui.BaseFragment

class FavouriteFragment : BaseFragment() {
    override val viewModel: ViewModel by viewModels()
    override val binding: ViewBinding by lazy { FFavouriteBinding.inflate(layoutInflater) }

    override fun observeViewModel() {

    }

    override fun prepare() {

    }
}