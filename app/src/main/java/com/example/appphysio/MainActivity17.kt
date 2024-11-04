package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity17 : AppCompatActivity() {

    private lateinit var imageButtonInicio: ImageButton
    private lateinit var imageButtonAgenda: ImageButton
    private lateinit var imageButtonNotificaciones: ImageButton
    private lateinit var imageButtonPerfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        // Inicializa los botones de la barra de navegación
        imageButtonInicio = findViewById(R.id.imageButtonInicio)
        imageButtonAgenda = findViewById(R.id.imageButtonAgenda)
        imageButtonNotificaciones = findViewById(R.id.imageButtonNotificaciones)
        imageButtonPerfil = findViewById(R.id.imageButtonPerfil)

        // Configura los listeners de los botones
        imageButtonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        imageButtonAgenda.setOnClickListener {
            // Acción para el botón de Agenda

        }

        imageButtonNotificaciones.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        imageButtonPerfil.setOnClickListener {
            val intent = Intent(this, MainActivity15::class.java)
            startActivity(intent)
        }
    }
}

