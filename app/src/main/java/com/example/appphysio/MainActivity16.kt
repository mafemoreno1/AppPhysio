package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity16 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main16)

        // Recuperar la fecha y hora de la cita desde el Intent
        val fechaCita = intent.getStringExtra("fechaCita")
        val horaCita = intent.getStringExtra("horaCita")


        // Mostrar la confirmación de cita en el TextView
        val textViewNotificacion = findViewById<TextView>(R.id.notifications)
        textViewNotificacion.text = "Cita confirmada para el $fechaCita a las $horaCita"

        // Configurar el botón de regreso
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        arrowIcon.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la anterior
        }

        // Configuración de la barra de navegación inferior
        findViewById<ImageButton>(R.id.buttonHome).setOnClickListener {
            startActivity(Intent(this, MainActivity6::class.java))
        }
        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            startActivity(Intent(this, MainActivity7::class.java))
        }
        findViewById<ImageButton>(R.id.buttonNotifications).setOnClickListener {
            startActivity(Intent(this, MainActivity16::class.java))
        }
        findViewById<ImageButton>(R.id.buttonProfile).setOnClickListener {
            startActivity(Intent(this, MainActivity14::class.java))
        }
    }
}

