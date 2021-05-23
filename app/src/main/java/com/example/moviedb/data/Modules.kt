package com.example.moviedb.data

import com.example.moviedb.data.api.NetworkModule
import com.example.moviedb.data.api.ResponseHandler
import com.example.moviedb.domain.usecases.AuthUseCase
import com.example.moviedb.domain.usecases.MovieUseCase
import com.example.moviedb.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    factory { NetworkModule.authApi() }
    factory { NetworkModule.movieApi() }
    factory { AuthUseCase(authApi = get(), responseHandler = get()) }
    factory { MovieUseCase(get()) }
    factory { ResponseHandler() }
}

val viewModelModule = module {
    viewModel {
        AuthViewModel(get())
    }
}
