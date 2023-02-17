package com.example.movie.registration

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.utils.FirebaseUtils.firebaseAuth

class RegistrationViewModel : ViewModel() {
    val userName = ObservableField<String>()
    val userNameError = ObservableField<String>()
    val email = ObservableField<String>()
    val emailError = ObservableField<String>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String>()
    var loading: Boolean = false
    val message = MutableLiveData<String>()
    var navigator: Navigator? = null


    fun createAccount() {
        if (isValid()) {
            createAccountInFB()
        }
    }

    private fun createAccountInFB() {
        loading = true
        try {
            loading = false
            firebaseAuth.createUserWithEmailAndPassword(
                email.get() ?: "", password.get() ?: ""
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    message.value = "Successfully Sign In"
                    navigator?.goToEmailLogin()
                } else {
                    message.value = "Failed to Sign In"
                }
            }


        } catch (ex: Exception) {
            loading = false
            message.value = ex.localizedMessage
        }

    }


    private fun isValid(): Boolean {
        var valid = true
        if (userName.get().isNullOrBlank()) {
            userNameError.set("Enter Your valid name")
            valid = false
        } else {
            userNameError.set(null)
        }
        if (email.get().isNullOrBlank()) {
            emailError.set("Enter Your valid Email")
            valid = false
        } else {
            emailError.set(null)
        }
        if (password.get().isNullOrBlank()) {
            passwordError.set("Enter Your valid Password")
            valid = false
        } else {
            passwordError.set(null)
        }

        return valid
    }


}