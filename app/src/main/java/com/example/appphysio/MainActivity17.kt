package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity17 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        // Botón de retroceso
        val backArrow = findViewById<ImageButton>(R.id.backArrow)
        backArrow.setOnClickListener {
            // Regresar a la actividad anterior
            onBackPressed()
        }

        // Manejo de los botones de la barra de navegación inferior
        val buttonInicio = findViewById<ImageButton>(R.id.imageButtonInicio)
        val buttonAgenda = findViewById<ImageButton>(R.id.imageButtonAgenda)
        val buttonNotificaciones = findViewById<ImageButton>(R.id.imageButtonNotificaciones)
        val buttonPerfil = findViewById<ImageButton>(R.id.imageButtonPerfil)

        buttonInicio.setOnClickListener {
            //Toast.makeText(this, "Inicio seleccionado", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity9::class.java)
            startActivity(intent)
        }

        buttonAgenda.setOnClickListener {
            //Toast.makeText(this, "Agenda seleccionada", Toast.LENGTH_SHORT).show()
        }

        buttonNotificaciones.setOnClickListener {
            //Toast.makeText(this, "Notificaciones seleccionadas", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity10::class.java)
            startActivity(intent)
        }

        buttonPerfil.setOnClickListener {
            //Toast.makeText(this, "Perfil seleccionado", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity15::class.java)
            startActivity(intent)
        }
    }
}



