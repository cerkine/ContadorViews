package com.example.contadorviews

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText = findViewById<EditText>(R.id.editTextNumber)
        val flBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton2)

        val number = intent.getIntExtra("NUMBER_COUNT",0)
        if (number != 0){
            editText.setText("$number")
        }

        flBtn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("NUMBER_COUNT", editText.text.toString().toInt())}
            startActivity(intent)
        }



    }
}