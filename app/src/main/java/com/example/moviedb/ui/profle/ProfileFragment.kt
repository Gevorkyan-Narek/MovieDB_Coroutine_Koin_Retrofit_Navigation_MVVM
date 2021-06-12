package com.example.moviedb.ui.profle

import androidx.fragment.app.viewModels
import com.example.moviedb.databinding.FProfileBinding
import com.example.moviedb.ui.BaseFragment

class ProfileFragment : BaseFragment() {
    override val viewModel: ProfileViewModel by viewModels()
    override val binding by lazy { FProfileBinding.inflate(layoutInflater) }

    override fun observeViewModel() {

    }

    override fun prepare() {

    }
}