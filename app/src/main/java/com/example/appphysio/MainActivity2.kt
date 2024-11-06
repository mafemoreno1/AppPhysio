package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var pacientesRef: DatabaseReference
    private lateinit var fisioterapeutasRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Referencias separadas para cada nodo
        pacientesRef = FirebaseDatabase.getInstance().getReference("users pacientes")
        fisioterapeutasRef = FirebaseDatabase.getInstance().getReference("users fisioterapeutas")

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, complete los campos", Toast.LENGTH_SHORT).show()
            } else {
                authenticateUser(email, password)
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
    }

    private fun authenticateUser(email: String, password: String) {
        // Buscar en el nodo de pacientes
        pacientesRef.orderByChild("email").equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        verificarUsuario(snapshot, password, "paciente")
                    } else {
                        // Si no se encuentra en pacientes, buscar en fisioterapeutas
                        fisioterapeutasRef.orderByChild("email").equalTo(email)
                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(snapshot: DataSnapshot) {
                                    if (snapshot.exists()) {
                                        verificarUsuario(snapshot, password, "fisioterapeuta")
                                    } else {
                                        Toast.makeText(this@MainActivity2, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                override fun onCancelled(error: DatabaseError) {
                                    Toast.makeText(this@MainActivity2, "Error en la base de datos", Toast.LENGTH_SHORT).show()
                                }
                            })
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity2, "Error en la base de datos", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun verificarUsuario(snapshot: DataSnapshot, password: String, perfil: String) {
        for (userSnapshot in snapshot.children) {
            val userPassword = userSnapshot.child("password").value.toString()
            if (userPassword == password) {
                val intent = if (perfil == "paciente") {
                    Intent(this@MainActivity2, MainActivity6::class.java)  // Menu paciente
                } else {
                    Intent(this@MainActivity2, MainActivity9::class.java)  // Menu fisioterapeuta
                }
                startActivity(intent)
                finish()
                return
            }
        }
        Toast.makeText(this@MainActivity2, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
    }
}
