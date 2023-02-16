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
import com.example.movie.Extensions
import com.example.movie.FirebaseUtils
import com.example.movie.R
import com.example.movie.databinding.FragmentRegesterationBinding

class Registration : Fragment() {
    lateinit var bind:FragmentRegesterationBinding
    val registrationViewModel: RegistrationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_regesteration, container, false)

        return bind.root
    }

}