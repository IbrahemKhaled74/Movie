package com.example.movie.utils


import android.content.Context
import android.widget.Toast

object Extensions {

    fun toastMessage(context:Context,msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }


}
