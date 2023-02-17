package com.example.movie.reset_pass

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.utils.FirebaseUtils.firebaseAuth

class ResetPassViewModel : ViewModel() {
    val email = ObservableField<String>()
    val emailError = ObservableField<String>()
    var navigator: Navigator? = null
    var message = MutableLiveData<String>()

    fun reset() {
        if (isValid()) {
            restPassword()
        }
    }

    private fun restPassword() {
        try {
            firebaseAuth.sendPasswordResetEmail(email.get() ?: "").addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigator?.goToEmailLogin()
                    message.value = "Please check your email for a link to reset!"
                }

            }
        } catch (ex: Exception) {
            message.value = ex.localizedMessage
        }

    }

    private fun isValid(): Boolean {
        var valid = true
        if (email.get().isNullOrBlank()) {
            emailError.set("Enter Your valid Email")
            valid = false
        } else {
            emailError.set(null)
        }
        return valid
    }


}