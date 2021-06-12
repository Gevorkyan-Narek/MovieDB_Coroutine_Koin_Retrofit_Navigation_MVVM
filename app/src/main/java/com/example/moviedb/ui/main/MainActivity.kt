package com.example.moviedb.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import com.example.moviedb.R
import com.example.moviedb.data.observe
import com.example.moviedb.databinding.AMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: AMainBinding by lazy { AMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModel()
    private val navController by lazy { (supportFragmentManager.findFragmentById(R.id.mainFragmentView) as NavHostFragment).navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        observeViewModel()
    }

    private fun observeViewModel() {
        observe(viewModel.destinationChanged) {
            binding.bottomNavigation.isVisible = it
            binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.profileMenuItem -> {
                        navController.navigate(R.id.profileFragment)
                        true
                    }
                    R.id.favouriteMenuItem -> {
                        navController.navigate(R.id.favouriteFragment)
                        true
                    }
                    R.id.moviesMenuItem -> {
                        navController.navigate(R.id.movieFragment)
                        true
                    }
                    else -> true
                }
            }
        }
    }

    private fun initView() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            viewModel.onDestinationChanged(destination)
        }
    }
}