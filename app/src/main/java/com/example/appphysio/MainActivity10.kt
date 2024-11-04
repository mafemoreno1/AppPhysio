package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity10 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        // Inicializa los íconos
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val imageButtonHome: ImageButton = findViewById(R.id.imageButtonInicio)
        val imageButtonNotifications: ImageButton = findViewById(R.id.imageButtonNotificaciones)
        val imageButtonAgenda: ImageButton = findViewById(R.id.imageButtonAgenda)
        val imageButtonProfile: ImageButton = findViewById(R.id.imageButtonPerfil)

        // Configuración de acciones para los íconos, por ejemplo:
        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Configura los listeners para los clics en los íconos
        imageButtonHome.setOnClickListener {
            // Lógica para ir a la pantalla de Inicio
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        imageButtonNotifications.setOnClickListener {
            //val intent = Intent(this, MainActivity10::class.java)
            //startActivity(intent)
        }

        imageButtonAgenda.setOnClickListener {
            val intent = Intent(this, MainActivity17::class.java)
            startActivity(intent)
        }

        imageButtonProfile.setOnClickListener {
            // Lógica para ir a la pantalla de Perfil
            val intent = Intent(this, MainActivity15::class.java)
            startActivity(intent)
        }
    }
}
