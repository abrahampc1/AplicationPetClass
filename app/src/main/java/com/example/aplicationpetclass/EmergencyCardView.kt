package com.example.aplicationpetclass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationpetclass.R
import com.example.aplicationpetclass.Veterinaria

class EmergencyCardView(private val veterinariaList: List<Veterinaria>, private val context: Context) :
    RecyclerView.Adapter<EmergencyCardView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_emergency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val veterinaria = veterinariaList[position]

        holder.nombreVeterinaria.text = veterinaria.nombre
        holder.direccionVeterinaria.text = veterinaria.direccion
        holder.telefonoVeterinaria.text = veterinaria.telefono
    }

    override fun getItemCount(): Int {
        return veterinariaList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreVeterinaria: TextView = itemView.findViewById(R.id.nombreVeterinaria)
        val direccionVeterinaria: TextView = itemView.findViewById(R.id.direccionVeterinaria)
        val telefonoVeterinaria: TextView = itemView.findViewById(R.id.telefonoVeterinaria)
    }
}
