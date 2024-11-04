package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity15 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main15)

        // Configura los botones de navegación
        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonAgenda = findViewById<ImageButton>(R.id.imageButtonAgenda)
        val buttonNotifications = findViewById<ImageButton>(R.id.buttonNotifications)
        val buttonProfile = findViewById<ImageButton>(R.id.buttonProfile)

        // Configura el botón de historial
        val buttonHistorial = findViewById<Button>(R.id.button7)

        // Configura el botón de regresar (flecha)
        val backButton = findViewById<ImageButton>(R.id.imageView7)

        // Define la acción para el botón de regresar
        backButton.setOnClickListener {
            finish() // Regresa a la actividad anterior
        }

        // Define la acción para el botón de historial
        buttonHistorial.setOnClickListener {
            Toast.makeText(this, "Historial del paciente", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity12::class.java)
            startActivity(intent)
        }

        // Acción para cada botón de la barra de navegación inferior
        buttonHome.setOnClickListener {
            //Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity9::class.java)
            startActivity(intent)
        }

        buttonAgenda.setOnClickListener {
            //Toast.makeText(this, "Agenda", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity17::class.java)
            startActivity(intent)
        }

        buttonNotifications.setOnClickListener {
            //Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity10::class.java)
            startActivity(intent)
        }

        buttonProfile.setOnClickListener {
            //Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            //val intent = Intent (this, MainActivity15::class.java)
            //startActivity(intent)
        }
    }
}





