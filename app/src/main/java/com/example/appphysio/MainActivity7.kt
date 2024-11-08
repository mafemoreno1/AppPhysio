package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity7 : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var buttonSeleccionarHora: Button
    private lateinit var imageButtonInicio: ImageButton
    private lateinit var imageButtonCalendario: ImageButton
    private lateinit var imageButtonNotificaciones: ImageButton
    private lateinit var imageButtonPerfil: ImageButton

    // Variable para almacenar la fecha seleccionada en formato de texto
    private var selectedDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        // Inicializa los elementos de la interfaz
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        calendarView = findViewById(R.id.calendarView)
        buttonSeleccionarHora = findViewById(R.id.button)
        imageButtonInicio = findViewById(R.id.imageButtonInicio)
        imageButtonCalendario = findViewById(R.id.imageButtonCalendario)
        imageButtonNotificaciones = findViewById(R.id.imageButtonNotificaciones)
        imageButtonPerfil = findViewById(R.id.imageButtonPerfil)

        // Acción para el icono de flecha, como regresar a la actividad anterior
        arrowIcon.setOnClickListener {
            finish()
        }

        // Listener para capturar la fecha seleccionada en el CalendarView
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            // Formatea la fecha seleccionada como "dd/MM/yyyy"
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            selectedDate = dateFormat.format(calendar.time) // Guarda la fecha seleccionada
        }

        // Listener para el botón de seleccionar hora, pasa la fecha a MainActivity8
        buttonSeleccionarHora.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            intent.putExtra("selectedDate", selectedDate)
            startActivity(intent)
        }

        // Configura los listeners para los botones de la barra de navegación
        imageButtonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        imageButtonCalendario.setOnClickListener {
            // Aquí podrías agregar acciones para el botón de Calendario, si es necesario
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



