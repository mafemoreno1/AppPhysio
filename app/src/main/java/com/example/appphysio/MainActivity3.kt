package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3 : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Inicializa la referencia a la base de datos
        database = FirebaseDatabase.getInstance().getReference("usuarios")

        val nameEditText = findViewById<EditText>(R.id.editTextNombre)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val confirmPasswordEditText = findViewById<EditText>(R.id.editTextConfirmPassword)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                // Crea un nuevo usuario
                val userId = database.push().key // Genera un ID único para el usuario
                val user = user(userId, name, email, password) // Crea un objeto User

                // Almacena el usuario en Firebase
                userId?.let {
                    database.child(it).setValue(user).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registro completado", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity6::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}

// Clase de modelo para el usuario
data class user(val userId: String?, val name: String, val email: String, val password: String)



