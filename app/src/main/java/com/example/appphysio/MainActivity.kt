package com.example.appphysio


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones desde el archivo XML
        val buttonIngresar = findViewById<Button>(R.id.buttonIngresar)


        // Acción para el botón Ingresar
        buttonIngresar.setOnClickListener {
            // Muestra un mensaje cuando se presiona el botón "Ingresar"
            //Toast.makeText(this, "Ingresar presionado", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}










