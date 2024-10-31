package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        // Referencias de vista
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val buttonSeleccionarHora = findViewById<Button>(R.id.button)
        val imageButtonInicio = findViewById<ImageButton>(R.id.imageButtonInicio)
        val imageButtonCalendario = findViewById<ImageButton>(R.id.imageButtonCalendario)
        val imageButtonNotificaciones = findViewById<ImageButton>(R.id.imageButtonNotificaciones)
        val imageButtonPerfil = findViewById<ImageButton>(R.id.imageButtonPerfil)

        // Configuración de acciones para los íconos, por ejemplo:
        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Navegación al seleccionar botón de hora
        buttonSeleccionarHora.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }

        // Ejemplo de funcionalidad para los iconos de la barra inferior
        imageButtonInicio.setOnClickListener {
            val intent = Intent (this, MainActivity6::class.java)
            startActivity(intent)
        }

        imageButtonCalendario.setOnClickListener {
            // Acción para botón Calendario
        }

        imageButtonNotificaciones.setOnClickListener {
            // Acción para botón Notificaciones
        }

        imageButtonPerfil.setOnClickListener {
            // Acción para botón Perfil
        }

        // Manejo de la selección de la fecha en el CalendarView
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val fechaSeleccionada = "$dayOfMonth/${month + 1}/$year"
            // Puedes actualizar un TextView u otra vista con la fecha seleccionada
        }
    }
}


