package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        // Referencias a los campos de entrada
        val nameEditText = findViewById<EditText>(R.id.editTextNombre)
        val specialityEditText = findViewById<EditText>(R.id.editTextNombre)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val confirmPasswordEditText = findViewById<EditText>(R.id.editTextConfirmPassword)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        // Acciones al presionar el botón de registro
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val speciality = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (name.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí puedes agregar la lógica para registrar al usuario (por ejemplo, en una base de datos)
                //Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, MainActivity9::class.java)
                startActivity(intent)

            }
        }
    }
}
