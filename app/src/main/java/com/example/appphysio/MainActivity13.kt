package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity13 : AppCompatActivity() {

    private lateinit var nameField: EditText
    private lateinit var ageField: EditText
    private lateinit var weightField: EditText
    private lateinit var observationsField: EditText
    private lateinit var saveChangesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        // Inicialización de los campos de entrada

        nameField = findViewById(R.id.name_field)
        ageField = findViewById(R.id.age_field)
        weightField = findViewById(R.id.weight_field)
        observationsField = findViewById(R.id.observations_field)
        saveChangesButton = findViewById(R.id.save_changes_button)

        // Listener para el botón de guardar cambios
        saveChangesButton.setOnClickListener {
            val name = nameField.text.toString()
            val age = ageField.text.toString()
            val weight = weightField.text.toString()
            val observations = observationsField.text.toString()


            // Realiza alguna acción con los datos ingresados
            Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show()

        }

        // Configuración de los botones de la barra inferior
        findViewById<ImageButton>(R.id.buttonHome).setOnClickListener {
            //Toast.makeText(this, "Inicio seleccionado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            //Toast.makeText(this, "Agenda seleccionada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonNotifications).setOnClickListener {
            //Toast.makeText(this, "Notificaciones seleccionadas", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonProfile).setOnClickListener {
            //Toast.makeText(this, "Perfil seleccionado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity14::class.java)
            startActivity(intent)
        }

        // Configuración del icono de flecha para regresar
        findViewById<ImageButton>(R.id.imageView7).setOnClickListener {
            finish()
        }
    }
}
