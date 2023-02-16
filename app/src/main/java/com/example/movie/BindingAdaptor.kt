package com.example.movie

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:error")
fun TextInputLayout.error(error: String?) {
    this.error = error
}

