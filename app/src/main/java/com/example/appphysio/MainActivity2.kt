package com.example.appphysio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Referencias a los campos de texto y botones
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // Acción para el botón de Ingresar
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validar que los campos no estén vacíos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, complete los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí se puede manejar la lógica de inicio de sesión
                //Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, MainActivity6::class.java)
                startActivity(intent)
            }
        }

        registerButton.setOnClickListener {
            //Toast.makeText(this, "Redirigiendo a registro...", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity4::class.java)
            startActivity(intent)
        }
    }
}

