package com.example.aplicationpetclass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EmergencyMainCard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emergency_card_main)

        val veterinariaList = listOf(
            Veterinaria("Veterinaria A", "Calle Principal 123", "111-222-3333"),
            Veterinaria("Veterinaria B", "Avenida Central 456", "444-555-6666"),
            Veterinaria("Veterinaria C", "Plaza Mayor 789", "777-888-9999"),
            Veterinaria("Veterinaria D", "Calle Secundaria 321", "123-456-7890"),
            Veterinaria("Veterinaria E", "Avenida Norte 654", "987-654-3210"),
            Veterinaria("Veterinaria F", "Esquina Este 987", "111-222-3333"),
            Veterinaria("Veterinaria G", "Calle Oeste 456", "444-555-6666"),
            Veterinaria("Veterinaria H", "Plaza Sur 789", "777-888-9999"),
            Veterinaria("Veterinaria I", "Avenida Principal 321", "123-456-7890"),
            Veterinaria("Veterinaria J", "Calle Central 654", "987-654-3210")
            // Agrega más según sea necesario
        )


        // Configura el RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = EmergencyCardView(veterinariaList, this)
        recyclerView.adapter = adapter
    }
}
