package com.example.movie

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:error")
fun TextInputLayout.error(error: String?) {
    this.error = error
}

@BindingAdapter("app:showLoading")
fun ProgressBar.show(visible:Boolean){
    this.isVisible=visible
}
