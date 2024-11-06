package com.example.appphysio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FisioterapeutaAdapter(
    private val fisioterapeutas: List<Fisioterapeuta>,
    private val onItemClick: (Fisioterapeuta) -> Unit
) : RecyclerView.Adapter<FisioterapeutaAdapter.FisioterapeutaViewHolder>() {

    class FisioterapeutaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.textViewNombreFisioterapeuta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FisioterapeutaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fisioterapeuta, parent, false)
        return FisioterapeutaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FisioterapeutaViewHolder, position: Int) {
        val fisioterapeuta = fisioterapeutas[position]
        holder.nombreTextView.text = fisioterapeuta.name
        holder.itemView.setOnClickListener {
            onItemClick(fisioterapeuta)
        }
    }

    override fun getItemCount(): Int {
        return fisioterapeutas.size
    }
}


