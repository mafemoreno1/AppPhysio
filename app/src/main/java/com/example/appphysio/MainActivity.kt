package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al botón "Ingresar"
        val buttonIngresar = findViewById<Button>(R.id.buttonIngresar)

        // Acción para el botón "Ingresar"
        buttonIngresar.setOnClickListener {
            // Al presionar el botón, se inicia MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}












