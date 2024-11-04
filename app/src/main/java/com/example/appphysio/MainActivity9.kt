package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        // Inicialización de los componentes del layout
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val titleTextView = findViewById<TextView>(R.id.title)
        val todayScheduleTextView = findViewById<TextView>(R.id.today_schedule)

        val homeIcon = findViewById<ImageView>(R.id.imageButtonInicio)
        val notificationsIcon = findViewById<ImageView>(R.id.imageButtonNotificaciones)
        val agendaIcon = findViewById<ImageView>(R.id.imageButtonAgenda)
        val profileIcon = findViewById<ImageView>(R.id.imageButtonPerfil)

        // Configuración de acciones para los íconos, por ejemplo:
        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        homeIcon.setOnClickListener {
            // Acción para el icono de Inicio
        }

        notificationsIcon.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        agendaIcon.setOnClickListener {
            val intent = Intent(this, MainActivity17::class.java)
            startActivity(intent)
        }

        profileIcon.setOnClickListener {
            val intent = Intent(this, MainActivity15::class.java)
            startActivity(intent)

        }

        // Puedes configurar otros comportamientos o actualizar los textos si es necesario
        titleTextView.text = "FISIOPLUS"
        todayScheduleTextView.text = "Recordatorio"
    }
}
