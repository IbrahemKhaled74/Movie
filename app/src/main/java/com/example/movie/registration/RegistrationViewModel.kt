package com.example.movie.registration

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class RegistrationViewModel:ViewModel() {
    val userName=ObservableField<String>()
    val userNameError=ObservableField<String>()
    val email=ObservableField<String>()
    val emailError=ObservableField<String>()
    val password=ObservableField<String>()
    val passwordError=ObservableField<String>()






}