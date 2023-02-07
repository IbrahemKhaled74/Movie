package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movie.databinding.ActivityMainBinding
import com.example.movie.databinding.FragmentLoginBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind=DataBindingUtil.setContentView(this,R.layout.activity_main)

    }
}