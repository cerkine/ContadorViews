package com.example.contadorviews.listener

import android.util.Log.w
import android.view.View

class LogComponentListener(val component: View) : CustomListener {
    override fun function() {
        w(null, "$component.id is being pressed")
    }


}