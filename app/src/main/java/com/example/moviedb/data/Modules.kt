package com.example.moviedb.data

import com.example.moviedb.MainActivity
import com.example.moviedb.data.api.AuthApi
import com.example.moviedb.domain.repository.AuthUseCase
import com.example.moviedb.ui.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    single<AuthApi> {
        AuthUseCase()
    }

    viewModel {
        AuthViewModel(get())
    }
}
