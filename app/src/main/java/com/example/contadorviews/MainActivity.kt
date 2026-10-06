package com.example.contadorviews

import android.os.Bundle
import android.util.Log.w
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var textView: TextView
    private val listeners = arrayListOf<ListenersCustom>()

    var comptador = 0
    var text = "Comptador $comptador"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        textView = findViewById(R.id.textView)
        listeners.addAll(
            arrayListOf(
                LogComponentListener(btn),
                LogComponentListener(textView),
                ToastShowListener(textView, "listener aplicado")
            )
        )

        textView.text = text

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn.setOnClickListener {
            comptador++
            listeners.forEach(ListenersCustom::apply)
        }

    }
}

interface ListenersCustom {
    fun listener()

    fun apply() {
        listener()
    }


}

class LogComponentListener(val component: View) : ListenersCustom {

    override fun listener() {
        w(null, "$component.id is being pressed")
    }

}

class ToastShowListener(val textView: TextView, val message: String) : ListenersCustom {
    override fun listener() {
        Toast.makeText(textView.context, message, LENGTH_SHORT).show()
    }

}
