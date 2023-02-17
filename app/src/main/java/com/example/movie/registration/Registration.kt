package com.example.movie.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movie.Extensions
import com.example.movie.Extensions.toastMessage
import com.example.movie.FirebaseUtils
import com.example.movie.R
import com.example.movie.databinding.FragmentRegesterationBinding

class Registration : Fragment(),Navigator {
    lateinit var bind:FragmentRegesterationBinding
    val registrationViewModel: RegistrationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_regesteration, container, false)
        bind.vm=registrationViewModel
        registrationViewModel.navigator=this
        showMessage()
        return bind.root
    }
    private fun showMessage(){
        registrationViewModel.message.observe(viewLifecycleOwner){
            toastMessage(requireContext(),it)
        }
    }

    override fun goToMainFragment() {
        findNavController().navigate(R.id.action_registration_to_mainFragment)
    }

}