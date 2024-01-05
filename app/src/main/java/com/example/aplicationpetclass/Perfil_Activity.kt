package com.example.aplicationpetclass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Perfil_Activity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextCorreo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        editTextNombre = findViewById(R.id.editTextNombrePerfil)
        editTextApellido = findViewById(R.id.editTextApellidoPerfil)
        editTextCorreo = findViewById(R.id.editTextTextEmailAddress)
        editTextTelefono = findViewById(R.id.editTextPhonePerfil)

        val usuario = intent.getSerializableExtra("usuario") as Usuario?

        usuario?.let {
            editTextNombre.setText(usuario.nombre)
            editTextApellido.setText(usuario.apellido)
            editTextCorreo.setText(usuario.correo)
            editTextTelefono.setText(usuario.telefono)
            // Deseas mostrar los datos del usuario, por lo que los campos no deberían ser editables
            editTextNombre.isEnabled = false
            editTextApellido.isEnabled = false
            editTextCorreo.isEnabled = false
            editTextTelefono.isEnabled = false
        }

        val button = findViewById<Button>(R.id.btnInicioPerfil)
        button.setOnClickListener {
            val lanzar = Intent(this, MainScreen::class.java)
            startActivity(lanzar)
        }
    }
}


