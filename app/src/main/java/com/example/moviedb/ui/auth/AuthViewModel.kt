package com.example.moviedb.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.api.ResponseStatuses
import com.example.moviedb.data.entity.auth.AuthResponse
import com.example.moviedb.data.isValid
import com.example.moviedb.data.toTimestamp
import com.example.moviedb.domain.usecases.AuthUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private var requestToken: AuthResponse? = null

    private val _loginLiveData = MutableLiveData<Unit>()
    val loginLiveData = _loginLiveData

    private val _errorLiveData = MutableLiveData<String?>()
    val errorLiveData = _errorLiveData

    fun onLoginClicked(login: String, password: String) {
        if (requestToken == null)
            createRequest(login, password)
        else
            requestToken?.let { request ->
                if (request.expiresAt.toTimestamp().isValid())
                    createSession(login, password, request)
                else
                    createRequest(login, password)
            }
    }

    private fun createRequest(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authUseCase.createRequestToken()
            if (response.status == ResponseStatuses.SUCCESS && response.data != null) {
                this@AuthViewModel.requestToken = response.data
                createSession(login, password, response.data)
            } else _errorLiveData.postValue(response.msg)
        }
    }

    private fun createSession(login: String, password: String, requestToken: AuthResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authUseCase.createSession(login, password, requestToken.requestToken)
            if (response.status == ResponseStatuses.SUCCESS)
                _loginLiveData.postValue(Unit)
            else
                _errorLiveData.postValue(response.msg)
        }
    }
}