package com.example.moviedb.ui.auth

import androidx.navigation.fragment.findNavController
import com.example.moviedb.R
import com.example.moviedb.data.clearText
import com.example.moviedb.data.observe
import com.example.moviedb.databinding.FAuthBinding
import com.example.moviedb.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment() {

    override val viewModel: AuthViewModel by viewModel()
    override val binding by lazy { FAuthBinding.inflate(layoutInflater) }

    override fun prepare() {
        with(binding) {
            enter.setOnClickListener {
                viewModel.onLoginClicked(
                    loginInput.text.toString(),
                    passwordInput.text.toString()
                )
            }
        }
    }

    override fun observeViewModel() {
        viewModel.run {
            with(binding) {
                observe(loginLiveData) {
                    error.clearText()
                    findNavController().navigate(R.id.action_authFragment_to_movieFragment2)
                }
                observe(errorLiveData) {
                    enter.setBackgroundColor(
                        resources.getColor(
                            R.color.orange,
                            context?.theme
                        )
                    )
                    enter.setTextColor(resources.getColor(R.color.white, context?.theme))
                    error.text = it
                }
            }
        }
    }
}