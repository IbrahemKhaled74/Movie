package com.example.movie.email_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentEmailLoginBinding


class EmailLogin : Fragment() {
    lateinit var bind: FragmentEmailLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= DataBindingUtil.inflate(inflater, R.layout.fragment_email_login, container, false)
        bind.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_emailLogin_to_mainFragment)
        }
        return bind.root
    }


}