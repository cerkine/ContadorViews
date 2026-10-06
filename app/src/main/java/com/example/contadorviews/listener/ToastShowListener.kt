package com.example.contadorviews.listener

import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class ToastShowListener(val component: TextView, val message: String): CustomListener {
    override fun function() {
        Toast.makeText(component.context, message, LENGTH_SHORT).show()
    }
}