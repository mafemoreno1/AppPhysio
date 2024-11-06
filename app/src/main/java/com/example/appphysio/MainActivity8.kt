package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class MainActivity8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        // Inicializar elementos de la interfaz
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val buttonConfirmar = findViewById<Button>(R.id.button2)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)

        // Recuperar la fecha de la cita de la actividad anterior
        val fechaCita = intent.getStringExtra("selectedDate")

        // ID del paciente y fisioterapeuta (reemplaza con los valores reales)
        val idPaciente = "id_del_paciente" // Este valor puede venir de FirebaseAuth o lógica de usuario
        val idFisioterapeuta = "id_del_fisioterapeuta" // Este valor depende del fisioterapeuta seleccionado

        // Configurar el TimePicker
        timePicker.setIs24HourView(false) // Modo de 12 horas

        // Acción para el icono de flecha
        arrowIcon.setOnClickListener {
            finish()
        }

        // Acción para el botón Confirmar
        buttonConfirmar.setOnClickListener {
            // Obtiene la hora y los minutos seleccionados en el TimePicker
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

            // Formato AM/PM
            val amPm = if (hour >= 12) "PM" else "AM"
            val hourIn12Format = if (hour % 12 == 0) 12 else hour % 12 // Conversión a 12 horas
            val formattedTime = String.format("%02d:%02d %s", hourIn12Format, minute, amPm)

            // Crear la referencia a Firebase Database para la rama "citas"
            val citasRef = FirebaseDatabase.getInstance().reference.child("citas")

            // Generar un ID único para la cita y manejar el caso nulo
            val citaID = citasRef.push().key
            if (citaID == null) {
                Toast.makeText(this, "Error al generar ID de cita", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Salir del bloque sin continuar la ejecución
            }

            // Crear el mapa de datos de la cita
            val citaData = mapOf(
                "pacienteID" to idPaciente,
                "fisioID" to idFisioterapeuta,
                "fecha" to fechaCita,
                "hora" to formattedTime
            )

            // Guardar la cita en Firebase bajo el ID de cita único
            citasRef.child(citaID).setValue(citaData).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Notificar al usuario que la cita se ha programado correctamente
                    Toast.makeText(this, "Cita programada con éxito", Toast.LENGTH_SHORT).show()

                    // Iniciar la actividad de notificaciones
                    val intentNotificaciones = Intent(this, MainActivity16::class.java)
                    intentNotificaciones.putExtra("fechaCita", fechaCita)
                    intentNotificaciones.putExtra("horaCita", formattedTime)
                    startActivity(intentNotificaciones)
                } else {
                    // Manejo de error en caso de fallo al guardar la cita
                    Toast.makeText(this, "Error al programar la cita", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Navegación en la barra inferior
        findViewById<ImageButton>(R.id.imageButtonInicio).setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imageButtonNotificaciones).setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imageButtonPerfil).setOnClickListener {
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }
    }
}

