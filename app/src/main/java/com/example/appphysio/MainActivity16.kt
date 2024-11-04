package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity16 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main16)

        // Botón de regresar
        val backButton: ImageButton = findViewById(R.id.imageView7)
        backButton.setOnClickListener {
            finish()
        }

        // Configuración de la barra de navegación inferior
        val homeButton: ImageButton = findViewById(R.id.buttonHome)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        val calendarButton: ImageButton = findViewById(R.id.imageButtonCalendario)
        calendarButton.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        val notificationsButton: ImageButton = findViewById(R.id.buttonNotifications)
        notificationsButton.setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        val profileButton: ImageButton = findViewById(R.id.buttonProfile)
        profileButton.setOnClickListener {
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }
    }
}
