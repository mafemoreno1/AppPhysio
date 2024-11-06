package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity14 : AppCompatActivity() {



    private lateinit var emailField: EditText
    private lateinit var birthDateField: EditText
    private lateinit var genderField: EditText
    private lateinit var addressField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)

        // Inicializar campos
        emailField = findViewById(R.id.email_field)
        birthDateField = findViewById(R.id.birthdate_field)
        genderField = findViewById(R.id.gender_field)
        addressField = findViewById(R.id.address_field)

        // Recibir los datos del perfil
        val nombre = intent.getStringExtra("nombre")
        val email = intent.getStringExtra("email")
        val birthDate = intent.getStringExtra("birthDate")
        val gender = intent.getStringExtra("gender")
        val address = intent.getStringExtra("address")


        // Mostrar los datos en los campos de texto
        emailField.setText(email)
        birthDateField.setText(birthDate)
        genderField.setText(gender)
        addressField.setText(address)

        // Configuración de los botones de la barra de navegación
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        // Flecha de regreso
        findViewById<ImageButton>(R.id.imageView7).setOnClickListener {
            onBackPressed()  // Navega a la actividad anterior
        }

        // Barra de navegación
        findViewById<ImageButton>(R.id.buttonHome).setOnClickListener {
            // Acción para "Inicio"
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            // Acción para "Calendario"
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonNotifications).setOnClickListener {
            // Acción para "Notificaciones"
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.buttonProfile).setOnClickListener {
            // Acción para "Perfil"
        }
    }
}



