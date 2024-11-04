package com.example.appphysio


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity14 : AppCompatActivity() {

    private lateinit var emailField: EditText
    private lateinit var birthDateField: EditText
    private lateinit var genderField: EditText
    private lateinit var addressField: EditText
    private lateinit var medicalHistoryButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)

        // Inicializar campos
        emailField = findViewById(R.id.email_field)
        birthDateField = findViewById(R.id.birthdate_field)
        genderField = findViewById(R.id.gender_field)
        addressField = findViewById(R.id.address_field)
        medicalHistoryButton = findViewById(R.id.medicalhistory_button)

        // Configurar botón de regresar
        val backButton: ImageButton = findViewById(R.id.imageView7)
        backButton.setOnClickListener {
            finish() // Regresar a la actividad anterior
        }

        // Configurar el botón de Historial médico
        medicalHistoryButton.setOnClickListener {
            // Aquí puedes agregar la lógica para abrir la actividad de historial médico
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }

        // Configurar barra de navegación inferior
        setupBottomNavBar()
    }

    private fun setupBottomNavBar() {
        findViewById<ImageButton>(R.id.buttonHome).setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonNotifications).setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonProfile).setOnClickListener {
            //val intent = Intent(this, MainActivity14::class.java)
            //startActivity(intent)
        }
    }
}