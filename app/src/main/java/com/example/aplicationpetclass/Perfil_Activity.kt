package com.example.aplicationpetclass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Perfil_Activity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Inicialización de elementos visuales
        editTextNombre = findViewById(R.id.editTextNombrePerfil)
        editTextApellido = findViewById(R.id.editTextApellidoPerfil)
        editTextCorreo = findViewById(R.id.editTextTextEmailAddress)
        editTextTelefono = findViewById(R.id.editTextPhonePerfil)

        // Obtener los datos del Intent si existen
        val usuario = intent.getSerializableExtra("usuario") as Usuario?

        // Mostrar los datos del usuario en los EditText si se encontró un usuario
        usuario?.let {
            editTextNombre.setText(usuario.nombre)
            editTextApellido.setText(usuario.apellido)
            editTextCorreo.setText(usuario.correo)
            editTextTelefono.setText(usuario.telefono)
        }

        val button = findViewById<Button>(R.id.btnInicioPerfil)
        button.setOnClickListener {
            val lanzar = Intent(this, MainScreen::class.java)
            startActivity(lanzar)
        }
    }

    // Función para obtener el correo del usuario desde SharedPreferences
    private fun obtenerCorreoUsuarioActual(): String {
        val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
        return sharedPreferences.getString("correo", "") ?: ""
    }
}
