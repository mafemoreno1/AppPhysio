package com.example.appphysio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity15 : AppCompatActivity() {

    private lateinit var emailfield: EditText
    private lateinit var birthdatefield: EditText
    private lateinit var genderfield: EditText
    private lateinit var specialityfield: EditText
    private lateinit var addressfield: EditText
    private lateinit var buttonHistory: Button
    private lateinit var buttonHome: ImageButton
    private lateinit var buttonAgenda: ImageButton
    private lateinit var buttonNotifications: ImageButton
    private lateinit var buttonProfile: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main15)

        // Inicializar los elementos de la interfaz
        emailfield = findViewById(R.id.email_field)
        birthdatefield= findViewById(R.id.birthdate_field)
        genderfield = findViewById(R.id.gender_field)
        specialityfield = findViewById(R.id.speciality_field)
        addressfield = findViewById(R.id.address_field)
        buttonHistory = findViewById(R.id.button7)
        buttonHome = findViewById(R.id.buttonHome)
        buttonAgenda = findViewById(R.id.imageButtonAgenda)
        buttonNotifications = findViewById(R.id.buttonNotifications)
        buttonProfile = findViewById(R.id.buttonProfile)

        // Acciones para los botones de navegación inferior
        buttonHome.setOnClickListener {
            //Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        buttonAgenda.setOnClickListener {
            //Toast.makeText(this, "Agenda", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity17::class.java)
            startActivity(intent)
        }

        buttonNotifications.setOnClickListener {
            //Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        // Acción para el botón "Historial Paciente"
        buttonHistory.setOnClickListener {
            // Cambia a la actividad del historial del paciente
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }
    }
}
