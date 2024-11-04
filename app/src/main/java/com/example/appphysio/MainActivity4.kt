package com.example.appphysio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val arrowIcon = findViewById<ImageView>(R.id.imageView7)

        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Botón Fisioterapeuta
        val fisioterapeutaButton: Button = findViewById(R.id.fisioterapeutaButton)
        fisioterapeutaButton.setOnClickListener {
            //Toast.makeText(this, "Iniciar sesión como Fisioterapeuta", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity5::class.java)
            startActivity(intent)
        }

        // Botón Paciente
        val pacienteButton: Button = findViewById(R.id.pacienteButton)
        pacienteButton.setOnClickListener {
            //Toast.makeText(this, "Iniciar sesión como Paciente", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity3::class.java)
            startActivity(intent)

        }
    }
}

