package com.example.movie

import android.app.Activity
import android.content.Context
import android.widget.Toast

object Extensions {

    fun toastMessage(context:Context,msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }


}
