package com.example.movie.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentLoginBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class Login : Fragment() {
    lateinit var bind: FragmentLoginBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var callbackManager: CallbackManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        signWithGoogle()
        signWithFaceBook()
        bind.googleLogin.setOnClickListener {
            signInWithGoogle()
        }

        bind.facebookLogin.setOnClickListener {
            signInWithFaceBook()
        }
        bind.emailLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_emailLogin)
        }
        bind.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_registration)

        }
        return bind.root
    }

    private fun signWithFaceBook() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
                override fun onSuccess(loginResult: LoginResult?) {
                    // App code
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                }
            })
    }

    private fun signInWithFaceBook() {


        LoginManager.getInstance()
            .logInWithReadPermissions(requireActivity(), listOf("public_profile"));
    }


    private fun signWithGoogle() {
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso);

    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task)
            }
        }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(requireActivity())
//        findNavController().navigate(R.id.)
    }

    private fun signInWithGoogle() {

        val signInIntent = mGoogleSignInClient.signInIntent
        resultLauncher.launch(signInIntent)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            Toast.makeText(requireContext(), "sign successfully", Toast.LENGTH_LONG).show()
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(requireContext(), "failed successfully", Toast.LENGTH_LONG).show()

        }
    }

}