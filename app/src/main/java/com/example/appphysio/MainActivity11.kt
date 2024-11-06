package com.example.appphysio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity11 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fisioterapeutaAdapter: FisioterapeutaAdapter
    private val fisioterapeutas = mutableListOf<Fisioterapeuta>()
    private val databaseReference = FirebaseDatabase.getInstance().reference.child("users fisioterapeutas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        // Inicializa el RecyclerView y el adaptador
        recyclerView = findViewById(R.id.recyclerViewFisioterapeutas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fisioterapeutaAdapter = FisioterapeutaAdapter(fisioterapeutas) { fisioterapeuta ->
            val intent = Intent(this, MainActivity7::class.java)
            intent.putExtra("fisioterapeuta_id", fisioterapeuta.id)
            intent.putExtra("fisioterapeuta_nombre", fisioterapeuta.name)
            startActivity(intent)
        }
        recyclerView.adapter = fisioterapeutaAdapter

        // Configura el botón de flecha para regresar a la actividad anterior
        val arrowIcon = findViewById<ImageButton>(R.id.imageView7)
        arrowIcon.setOnClickListener {
            onBackPressed()
        }

        // Carga los datos de los fisioterapeutas y configura la barra inferior
        cargarFisioterapeutas()
        setupBottomBar()
    }

    private fun cargarFisioterapeutas() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                fisioterapeutas.clear()
                for (fisioterapeutaSnapshot in snapshot.children) {
                    val fisioterapeuta = fisioterapeutaSnapshot.getValue(Fisioterapeuta::class.java)
                    if (fisioterapeuta != null) {
                        fisioterapeutas.add(fisioterapeuta)
                    }
                }
                fisioterapeutaAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity11, "Error al cargar los fisioterapeutas", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupBottomBar() {
        findViewById<ImageButton>(R.id.imageButtonInicio).setOnClickListener {
            startActivity(Intent(this, MainActivity6::class.java))
        }

        findViewById<ImageButton>(R.id.imageButtonCalendario).setOnClickListener {
            startActivity(Intent(this, MainActivity7::class.java))
        }

        findViewById<ImageButton>(R.id.imageButtonNotificaciones).setOnClickListener {
            startActivity(Intent(this, MainActivity16::class.java))
        }

        findViewById<ImageButton>(R.id.imageButtonPerfil).setOnClickListener {
            startActivity(Intent(this, MainActivity14::class.java))
        }
    }
}









