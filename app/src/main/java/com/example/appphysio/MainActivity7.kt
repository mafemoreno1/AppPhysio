package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity7 : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var buttonSeleccionarHora: Button
    private lateinit var imageButtonInicio: ImageButton
    private lateinit var imageButtonCalendario: ImageButton
    private lateinit var imageButtonNotificaciones: ImageButton
    private lateinit var imageButtonPerfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        // Inicializa los elementos de la interfaz
        calendarView = findViewById(R.id.calendarView)
        buttonSeleccionarHora = findViewById(R.id.button)
        imageButtonInicio = findViewById(R.id.imageButtonInicio)
        imageButtonCalendario = findViewById(R.id.imageButtonCalendario)
        imageButtonNotificaciones = findViewById(R.id.imageButtonNotificaciones)
        imageButtonPerfil = findViewById(R.id.imageButtonPerfil)

        // Configura el listener para el botón de seleccionar hora
        buttonSeleccionarHora.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }

        // Configura los listeners para los botones de la barra de navegación
        imageButtonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        imageButtonCalendario.setOnClickListener {

        }

        imageButtonNotificaciones.setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        imageButtonPerfil.setOnClickListener {
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }
    }
}



