package com.example.moviedb.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.data.entity.auth.RequestToken
import com.example.moviedb.data.entity.auth.Session
import com.example.moviedb.domain.usecases.AuthUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val requestToken: RequestToken? = null

    private val _loginLiveData = MutableLiveData<Unit>()
    val loginLiveData = _loginLiveData

    fun onLoginClicked(login: String, password: String) {
        GlobalScope.launch {

            with(authUseCase) {
                if (requestToken != null)
                // expires is OK
                    createSession(login, password, requestToken.requestToken).collect {
                        if (it.success)
                            _loginLiveData.postValue(Unit)
                    }
                else
                    createRequestToken().collect { requestToken ->
                        createSession(login, password, requestToken.requestToken).collect {
                            if (it.success)
                                _loginLiveData.postValue(Unit)
                        }
                    }
            }
        }
    }
}