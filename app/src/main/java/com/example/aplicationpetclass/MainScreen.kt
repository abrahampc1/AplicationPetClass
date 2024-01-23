package com.example.aplicationpetclass

import GPS_Activity
import Health_Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val button2 = findViewById<Button>(R.id.btnSalir)
        button2.setOnClickListener {
            mostrarDialogoCerrarSesion()
        }

        val button4 = findViewById<ImageView>(R.id.imgGPS)
        button4.setOnClickListener{
            val lanzar = Intent(this, MapsActivity::class.java)
            startActivity(lanzar)
        }

        val img1 = findViewById<ImageView>(R.id.imgAlarm)
        img1.setOnClickListener{
            val lanzar = Intent(this, MapView::class.java)
            startActivity(lanzar)
        }

        val img2 = findViewById<ImageView>(R.id.imgEmergency)
        img2.setOnClickListener{
            val lanzar = Intent(this, EmergencyMainCard::class.java)
            startActivity(lanzar)
        }

        val img67 = findViewById<ImageView>(R.id.imgHealth)
        img67.setOnClickListener{
            // Obtener el ID del usuario desde SharedPreferences
            val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
            val idUsuario = sharedPreferences.getInt("id", -1)

            // Verificar si el ID es válido antes de iniciar RegisterPetActivity
            if (idUsuario != -1) {
                // Pasar el ID del usuario a RegisterPetActivity
                val intent = Intent(this, RegisterPetActivity::class.java)
                intent.putExtra("idUsuario", idUsuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error: ID de usuario no válido", Toast.LENGTH_SHORT).show()
            }
        }

        val botonPerfil = findViewById<Button>(R.id.btnPerfilUsuario)
        botonPerfil.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
            val id = sharedPreferences.getInt("id", -1)
            val nombre = sharedPreferences.getString("nombre", "")
            val apellido = sharedPreferences.getString("apellido", "")
            val telefono = sharedPreferences.getString("telefono", "")
            val correo = sharedPreferences.getString("correo", "")
            val contrasena = sharedPreferences.getString("contrasena", "")

            val usuario = Usuario(id, nombre ?: "", apellido ?: "", telefono ?: "", correo ?: "", contrasena ?: "")

            if (usuario.id != -1 && usuario.nombre.isNotEmpty() && usuario.apellido.isNotEmpty()
                && usuario.telefono.isNotEmpty() && usuario.correo.isNotEmpty() && usuario.contrasena.isNotEmpty()) {
                val intent = Intent(this, Perfil_Activity::class.java)
                intent.putExtra("usuario", usuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error al mostrar los datos del perfil", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun mostrarDialogoCerrarSesion() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Cerrar Sesión")
        builder.setMessage("¿Estás seguro de que quieres cerrar sesión?")

        builder.setPositiveButton("Sí") { _, _ ->
            val lanzar3 = Intent(this, MainActivity::class.java)
            startActivity(lanzar3)
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}
