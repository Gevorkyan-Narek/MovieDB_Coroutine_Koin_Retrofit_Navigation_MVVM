package com.example.moviedb.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDestination
import com.example.moviedb.R

class MainViewModel : ViewModel() {
    private val _destinationChanged = MutableLiveData<Boolean>()
    val destinationChanged = _destinationChanged

    fun onDestinationChanged(destination: NavDestination) {
        if (destination.id != R.id.authFragment)
            _destinationChanged.postValue(true)
    }

}