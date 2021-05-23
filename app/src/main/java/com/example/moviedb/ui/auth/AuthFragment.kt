package com.example.moviedb.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviedb.R
import com.example.moviedb.databinding.FgAuthBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : Fragment() {

    private val authViewModel: AuthViewModel by viewModel()
    private val binding by lazy { FgAuthBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        prepare()
    }

    private fun prepare() {
        with(binding) {
            enter.setOnClickListener {
                authViewModel.onLoginClicked(
                    loginInput.text.toString(),
                    passwordInput.text.toString()
                )
            }
        }
    }

    private fun observeViewModel() {
        authViewModel.run {
            loginLiveData.observe(viewLifecycleOwner, {
                binding.error.text = ""
                findNavController().navigate(R.id.action_authFragment_to_movieFragment2)
            })
            errorLiveData.observe(viewLifecycleOwner, {
                errorButton(it)
            })
        }
    }

    private fun errorButton(error: String?) {
        binding.enter.setBackgroundColor(resources.getColor(R.color.orange, context?.theme))
        binding.enter.setTextColor(resources.getColor(R.color.white, context?.theme))
        binding.error.text = error
    }
}