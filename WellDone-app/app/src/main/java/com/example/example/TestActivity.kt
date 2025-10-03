package com.example.example

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Создаем интерфейс программно, без XML
        val textView = TextView(this).apply {
            text = "Привет! Это работает!"
            textSize = 20f
            setPadding(50, 50, 50, 50)
        }

        val button = Button(this).apply {
            text = "Нажми меня"
            setOnClickListener {
                textView.text = "УРА! Кнопка работает! 🎉"
            }
        }

        // Простой линейный layout
        val layout = androidx.appcompat.widget.LinearLayoutCompat(this).apply {
            orientation = androidx.appcompat.widget.LinearLayoutCompat.VERTICAL
            addView(textView)
            addView(button)
        }

        setContentView(layout)
    }
}