package com.example.appphysio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity6 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        // Inicialización de botones e íconos en el layout
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val inicioButton: ImageButton = findViewById(R.id.imageButtonInicio)
        val calendarioButton: ImageButton = findViewById(R.id.imageButtonCalendario)
        val notificacionesButton: ImageButton = findViewById(R.id.imageButtonNotificaciones)
        val perfilButton: ImageButton = findViewById(R.id.imageButtonPerfil)


        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Asignación de listeners para cada botón
        inicioButton.setOnClickListener {
            val btnInicio: ImageButton = findViewById(R.id.imageButtonInicio)
            btnInicio.setOnClickListener {
                //val intent = Intent(this, InicioActivity::class.java)
                //startActivity(intent)
            }

        }

        calendarioButton.setOnClickListener {
            val btnCalendario: ImageButton = findViewById(R.id.imageButtonCalendario)
            btnCalendario.setOnClickListener {
                val intent = Intent (this, MainActivity11::class.java)
                startActivity(intent)

            }

        }

        notificacionesButton.setOnClickListener {
            val btnNotificaciones: ImageButton = findViewById(R.id.imageButtonNotificaciones)
            btnNotificaciones.setOnClickListener {
                val intent = Intent(this, MainActivity16::class.java)
                startActivity(intent)
            }
        }

        perfilButton.setOnClickListener {
            val btnPerfil: ImageButton = findViewById(R.id.imageButtonPerfil)
            btnPerfil.setOnClickListener {
                val intent = Intent(this, MainActivity14::class.java)
                startActivity(intent)
            }

        }

        // Configuración de los TextViews con datos de citas
        val subtitulo:TextView=findViewById(R.id.textViewSubtitulo)


        // Configura los textos de las citas como sea necesario
        subtitulo.text = "Recordatorio"

    }
}















