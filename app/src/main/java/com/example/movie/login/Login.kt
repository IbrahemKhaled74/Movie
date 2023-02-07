package com.example.movie.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movie.R
import com.example.movie.databinding.FragmentLoginBinding

class Login : Fragment() {
    lateinit var bind:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind=DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return bind.root
    }


}