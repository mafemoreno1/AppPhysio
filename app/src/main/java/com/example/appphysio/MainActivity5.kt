package com.example.appphysio


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity5 : AppCompatActivity() {

    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        // Inicializa la referencia a la base de datos
        database = FirebaseDatabase.getInstance().getReference("usuarios")

        // Referencias a los campos de entrada
        val nameEditText = findViewById<EditText>(R.id.editTextNombre)
        val locationEditText = findViewById<EditText>(R.id.editTextNombre)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val confirmPasswordEditText = findViewById<EditText>(R.id.editTextConfirmPassword)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        // Acciones al presionar el botón de registro
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val location = locationEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            // Validación de entradas
            when {
                name.isEmpty() -> showToast("Por favor, ingresa tu nombre")
                location.isEmpty() -> showToast("Por favor, ingresa tu ubicación")
                email.isEmpty() -> showToast("Por favor, ingresa tu correo electrónico")
                password.isEmpty() -> showToast("Por favor, ingresa tu contraseña")
                confirmPassword.isEmpty() -> showToast("Por favor, confirma tu contraseña")
                password != confirmPassword -> showToast("Las contraseñas no coinciden")
                else -> registerUser(name, location, email, password)
            }
        }
    }

    private fun registerUser(name: String, location: String, email: String, password: String) {
        // Crear un nuevo usuario
        val userId = database.push().key // Genera un ID único para el usuario
        val user = User(userId, name, location, email, password) // Crea un objeto User

        // Almacena el usuario en Firebase
        userId?.let {
            database.child(it).setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro completado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity9::class.java)
                    startActivity(intent)
                    finish() // Cierra MainActivity5 para evitar volver al presionar atrás
                } else {
                    Log.e("FirebaseError", "Error al registrar usuario: ${task.exception?.message}")
                    showToast("Error al registrar usuario: ${task.exception?.message}")
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

// Clase de modelo para el usuario
data class User(val userId: String?, val name: String, val location: String, val email: String, val password: String)
