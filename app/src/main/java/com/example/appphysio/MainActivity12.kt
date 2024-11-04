package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity12 : AppCompatActivity() {

    private lateinit var nameField: EditText
    private lateinit var ageField: EditText
    private lateinit var weightField: EditText
    private lateinit var observationsField: EditText
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        // Inicialización de los campos de entrada
        nameField = findViewById(R.id.name_field)
        ageField = findViewById(R.id.age_field)
        weightField = findViewById(R.id.weight_field)
        observationsField = findViewById(R.id.observations_field)
        editButton = findViewById(R.id.edit_button)


        // Listener para el botón de editar
        editButton.setOnClickListener {
            // Realiza alguna acción al editar, como guardar los datos
            //Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity13::class.java)
            startActivity(intent)
        }

        // Configuración de los botones de la barra inferior
        findViewById<ImageButton>(R.id.buttonHome).setOnClickListener {
            //Toast.makeText(this, "Inicio seleccionado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            // Acción para el botón de Agenda
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonNotifications).setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonProfile).setOnClickListener {
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }

        // Configuración del icono de flecha para regresar
        findViewById<ImageButton>(R.id.imageView7).setOnClickListener {
            finish()
        }
    }
}

