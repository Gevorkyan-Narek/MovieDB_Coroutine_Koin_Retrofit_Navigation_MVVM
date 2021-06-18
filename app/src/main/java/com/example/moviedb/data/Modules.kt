package com.example.moviedb.data

import com.example.moviedb.data.api.NetworkModule
import com.example.moviedb.data.api.ResponseHandler
import com.example.moviedb.domain.usecases.AuthUseCase
import com.example.moviedb.domain.usecases.MovieRepository
import com.example.moviedb.ui.auth.AuthViewModel
import com.example.moviedb.ui.favourite.FavouriteViewModel
import com.example.moviedb.ui.main.MainViewModel
import com.example.moviedb.ui.movie.MovieContainerViewModel
import com.example.moviedb.ui.movie.detail.MovieDetailViewModel
import com.example.moviedb.ui.movie.search.MovieSearchViewModel
import com.example.moviedb.ui.movie.top_rate.MovieTopRateViewModel
import com.example.moviedb.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    factory { NetworkModule.authApi() }
    factory { NetworkModule.movieApi() }
    factory { ResponseHandler() }

    single { AuthUseCase(authApi = get(), responseHandler = get()) }
    single { MovieRepository(movieApi = get(), responseHandler = get()) }
}

val viewModelModule = module {
    viewModel {
        AuthViewModel(
            authUseCase = get()
        )
    }
    viewModel {
        MovieContainerViewModel()
    }
    viewModel {
        MovieSearchViewModel()
    }
    viewModel {
        MovieTopRateViewModel(get())
    }
    viewModel {
        MainViewModel()
    }
    viewModel {
        FavouriteViewModel()
    }
    viewModel {
        ProfileViewModel()
    }
    viewModel {
        MovieDetailViewModel(
            movieRepository = get()
        )
    }
}
