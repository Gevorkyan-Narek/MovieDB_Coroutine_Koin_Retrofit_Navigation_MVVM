package com.example.moviedb.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.data.entity.auth.RequestToken
import com.example.moviedb.data.entity.auth.Session
import com.example.moviedb.domain.repository.AuthUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val requestToken: RequestToken? = null

    private val _loginLiveData = MutableLiveData<Session>()
    val loginLiveData = _loginLiveData

    fun onLoginClicked() {
        GlobalScope.launch {

            with(authUseCase) {
                if (requestToken != null)
                // expires is OK
                    createSession(requestToken.requestToken).collect {
                        _loginLiveData.value = it
                    }
                else
                    createRequestToken().collect { requestToken ->
                        createSession(requestToken.requestToken).collect {
                            _loginLiveData.value = it
                        }
                    }
            }
        }
    }
}