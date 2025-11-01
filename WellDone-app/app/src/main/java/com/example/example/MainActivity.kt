package com.example.example

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Простейший интерфейс без XML
        val textView = TextView(this).apply {
            text = "Здравствуйте, Илья Львочич"
            textSize = 50f
            setPadding(50, 100, 50, 50)
        }

        val button = Button(this).apply {
            text = "Нажми на меня"
            setOnClickListener {
                textView.text = "УСПЕХ!!"
            }
        }

        val layout = LinearLayoutCompat(this).apply {
            orientation = LinearLayoutCompat.VERTICAL
            gravity = android.view.Gravity.CENTER
            addView(textView)
            addView(button)
        }

        setContentView(layout)
    }
}