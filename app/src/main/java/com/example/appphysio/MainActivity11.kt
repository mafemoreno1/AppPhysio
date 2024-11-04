package com.example.appphysio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity11 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        // Botones para seleccionar perfiles
        val buttonAlexa = findViewById<Button>(R.id.alexaButton)
        val buttonFelipe = findViewById<Button>(R.id.felipeButton)
        val buttonSofia = findViewById<Button>(R.id.sofiaButton)

        // Botones del menú inferior
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val buttonInicio = findViewById<ImageButton>(R.id.imageButtonInicio)
        val buttonCalendario = findViewById<ImageButton>(R.id.imageButtonCalendario)
        val buttonNotificaciones = findViewById<ImageButton>(R.id.imageButtonNotificaciones)
        val buttonPerfil = findViewById<ImageButton>(R.id.imageButtonPerfil)

        // Configuración de acciones para los íconos, por ejemplo:
        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Configurar los botones para que respondan al clic
        buttonAlexa.setOnClickListener {
            // Código para manejar el clic en "Alexa"
            Toast.makeText(this, "Seleccionado: Alexa", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity7::class.java)
            startActivity(intent)

        }

        buttonFelipe.setOnClickListener {
            Toast.makeText(this, "Seleccionado: Felipe", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity7::class.java)
            startActivity(intent)
        }

        buttonSofia.setOnClickListener {
            // Código para manejar el clic en "Sofia"
            Toast.makeText(this, "Seleccionado: Sofia", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity7::class.java)
            startActivity(intent)
        }

        buttonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        buttonCalendario.setOnClickListener {

        }

        buttonNotificaciones.setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        buttonPerfil.setOnClickListener {
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }
    }
}







