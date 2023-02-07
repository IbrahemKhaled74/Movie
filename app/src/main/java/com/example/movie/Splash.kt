package com.example.movie

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Splash : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (onBoardingFinished()) {
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splash_to_login)
            }, 3000)
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splash_to_viewPager)
            }, 3000)
        }
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    private fun onBoardingFinished(): Boolean {
        val sharedPerf = requireActivity().getSharedPreferences(Constants.onBoarding, Context.MODE_PRIVATE)
        return sharedPerf.getBoolean(Constants.finish, false)
    }

}