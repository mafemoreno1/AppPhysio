package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity17 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        // Configuración del botón de retroceso
        val backArrow = findViewById<ImageButton>(R.id.backArrow)
        backArrow.setOnClickListener {
            onBackPressed()
        }

        // Configuración de la barra de navegación inferior
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        findViewById<ImageButton>(R.id.imageButtonInicio).setOnClickListener {
            startActivity(Intent(this, MainActivity9::class.java))
        }
        findViewById<ImageButton>(R.id.imageButtonAgenda).setOnClickListener {
            // Aquí puedes agregar la acción para el botón de "Agenda" si es necesario
        }
        findViewById<ImageButton>(R.id.imageButtonNotificaciones).setOnClickListener {
            startActivity(Intent(this, MainActivity10::class.java))
        }
        findViewById<ImageButton>(R.id.imageButtonPerfil).setOnClickListener {
            startActivity(Intent(this, MainActivity15::class.java))
        }
    }
}




