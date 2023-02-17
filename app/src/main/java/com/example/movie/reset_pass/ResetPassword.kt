package com.example.movie.reset_pass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentResetPasswordBinding
import com.example.movie.utils.Extensions.toastMessage

class ResetPassword : Fragment(), Navigator {
    lateinit var bind: FragmentResetPasswordBinding
    val resetPassViewModel: ResetPassViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_reset_password, container, false
        )
        bind.vm = resetPassViewModel
        resetPassViewModel.navigator = this
        showMessage()
        return bind.root
    }

    override fun goToEmailLogin() {
        findNavController().navigate(R.id.action_resetPassword_to_emailLogin)
    }

    private fun showMessage() {
        resetPassViewModel.message.observe(viewLifecycleOwner) { message ->
            toastMessage(requireContext(), message)
        }
    }
}