package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        // Inicializar elementos de la interfaz
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        val imageView7 = findViewById<ImageButton>(R.id.imageView7)
        val buttonConfirmar = findViewById<Button>(R.id.button2)
        val buttonCancelar = findViewById<Button>(R.id.button3)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val textViewHora = findViewById<TextView>(R.id.textView4)

        // Configuración de acciones para los íconos, por ejemplo:
        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Configurar el TimePicker
        timePicker.setIs24HourView(false)  // Modo de 12 horas

        // Acciones de botones
        buttonConfirmar.setOnClickListener {
            val hour = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                timePicker.hour
            } else {
                timePicker.currentHour
            }
            val minute = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                timePicker.minute
            } else {
                timePicker.currentMinute
            }
            val amPm = if (hour >= 12) "PM" else "AM"
            val hourIn12Format = if (hour % 12 == 0) 12 else hour % 12  // Conversión a 12 horas

            val formattedTime = String.format("%02d:%02d %s", hourIn12Format, minute, amPm)
            Toast.makeText(this, "Cita confirmada : $formattedTime", Toast.LENGTH_SHORT).show()
        }

        // Navegación en la barra inferior
        findViewById<ImageButton>(R.id.imageButtonInicio).setOnClickListener {
            //Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            //Toast.makeText(this, "Calendario", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imageButtonNotificaciones).setOnClickListener {
            //Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imageButtonPerfil).setOnClickListener {
            //Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }
    }
}
