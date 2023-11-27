package com.example.aplicationpetclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Perfil_Activity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextCorreo: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

// Recibir los datos pasados desde MainScreen
        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val correo = intent.getStringExtra("correo")
        val telefono = intent.getStringExtra("telefono")

        // Enlazar los EditText en el layout con las variables
        val editTextNombre = findViewById<EditText>(R.id.editTextNombrePerfil)
        val editTextApellido = findViewById<EditText>(R.id.editTextApellidoPerfil)
        val editTextCorreo = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTelefono = findViewById<EditText>(R.id.editTextPhonePerfil)

        // Mostrar los datos en los EditText
        editTextNombre.setText(nombre)
        editTextApellido.setText(apellido)
        editTextCorreo.setText(correo)
        editTextTelefono.setText(telefono)

        // Establecer los EditText como no editables (opcional)
        editTextNombre.isEnabled = false
        editTextApellido.isEnabled = false
        editTextCorreo.isEnabled = false
        editTextTelefono.isEnabled = false

        val button= findViewById<Button>(R.id.btnInicioPerfil)
        button.setOnClickListener{
            val lanzar = Intent(this, MainScreen::class.java)
            startActivity(lanzar)
        }

        val button1= findViewById<Button>(R.id.btnPerfilPefil)
        button1.setOnClickListener{
            val lanzar2 = Intent(this, Perfil_Activity::class.java)
            startActivity(lanzar2)
        }
        val button2= findViewById<Button>(R.id.btnSalirPerfil)
        button2.setOnClickListener{
            val lanzar3 = Intent(this, MainScreen::class.java)
            startActivity(lanzar3)
        }
    }
}