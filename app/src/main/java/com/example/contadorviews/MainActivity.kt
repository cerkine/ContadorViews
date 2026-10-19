package com.example.contadorviews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //lateinit var btn: Button
    lateinit var textView: TextView
    //private val listeners = arrayListOf<ListenersCustom>()

    var comptador = 0
    fun text() = "Comptador $comptador"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)
        val btn2 = findViewById<Button>(R.id.btn2)
        textView = findViewById(R.id.textView)
        /*listeners.addAll(
            arrayListOf(
                LogComponentListener(btn),
                LogComponentListener(textView),
                ToastShowListener(textView, "listener aplicado")
            )
        )*/
        intent.getIntExtra("NUMBER_COUNT",0).apply {
            comptador = this
            textView.text = text()
        }
        textView.text = text()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn.setOnClickListener {
            comptador++
            textView.text = text()

        }

        btn2.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("NUMBER_COUNT", comptador)}
            startActivity(intent)
        }

    }
}
