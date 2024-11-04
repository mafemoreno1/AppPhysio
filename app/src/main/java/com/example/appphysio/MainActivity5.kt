package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity5 : AppCompatActivity() {

    // Variables de Firebase
    private lateinit var auth: FirebaseAuth
    private val database = FirebaseDatabase.getInstance()
    private val usersRef = database.getReference("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        // Inicializar Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Referencias a los campos de entrada
        val arrowIcon = findViewById<ImageView>(R.id.imageView7)
        val nameEditText = findViewById<EditText>(R.id.editTexNombre)
        val locationEditText = findViewById<EditText>(R.id.editTextUbicacion)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val confirmPasswordEditText = findViewById<EditText>(R.id.editTextConfirmPassword)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        arrowIcon.setOnClickListener {
            // Acción para el icono de flecha, como regresar a la actividad anterior
            finish()
        }

        // Acciones al presionar el botón de registro
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val location = locationEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (name.isEmpty() || location.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                // Registrar al usuario en Firebase Authentication
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Obtener el ID del usuario registrado
                            val userId = auth.currentUser?.uid
                            if (userId != null) {
                                // Guardar los datos en Firebase Realtime Database
                                val userMap = mapOf(
                                    "name" to name,
                                    "location" to location,
                                    "email" to email,
                                    "password" to password
                                )
                                usersRef.child(userId).setValue(userMap)
                                    .addOnSuccessListener {
                                        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                                        // Redirigir a MainActivity9
                                        val intent = Intent(this, MainActivity9::class.java)
                                        startActivity(intent)
                                        finish()
                                    }
                                    .addOnFailureListener {
                                        Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
                                    }
                            }
                        } else {
                            Toast.makeText(this, "Error en el registro: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}



