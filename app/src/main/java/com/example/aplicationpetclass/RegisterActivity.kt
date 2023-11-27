package com.example.aplicationpetclass

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class RegisterActivity<FirebaseUser> : AppCompatActivity() {


    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextContrasena: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegistro = findViewById<Button>(R.id.btnRegisterRegister)

        val txt= findViewById<TextView>(R.id.txtIniciaSesionRegister)
        txt.setOnClickListener{
            val lanzar3 = Intent(this, MainActivity::class.java)
            startActivity(lanzar3)
        }


        // Referencias a los EditText en el layout
        editTextNombre = findViewById(R.id.editTextName)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextTelefono = findViewById(R.id.editTextNumberPhoneRegister)
        editTextCorreo = findViewById(R.id.editTextTextEmail)
        editTextContrasena = findViewById(R.id.editTextTextPasswordRegister)

        val db = DatabaseHandler(this)

        registrarUsuario()

        btnRegistro.setOnClickListener {
            // Obtener los valores de los EditText
            val nombre = editTextNombre.text.toString()
            val apellido = editTextApellido.text.toString()
            val telefono = editTextTelefono.text.toString()
            val correo = editTextCorreo.text.toString()
            val contrasena = editTextContrasena.text.toString()

            if (nombre.isNotBlank() && apellido.isNotBlank() && telefono.isNotBlank() && correo.isNotBlank() && contrasena.isNotBlank()) {
                val db = DatabaseHandler(this)

                // Verificar si el número de teléfono o correo ya existen en la base de datos
                if (!db.existeTelefono(telefono) && !db.existeCorreo(correo)) {
                    // Si no existen, registrar al usuario
                    val nuevoUsuario = Usuario(
                        nombre = nombre,
                        apellido = apellido,
                        telefono = telefono,
                        correo = correo,
                        contrasena = contrasena
                    )

                    val idNuevoUsuario = db.agregarUsuario(nuevoUsuario)

                    if (idNuevoUsuario != -1L) {
                        // Usuario registrado con éxito
                        mostrarMensaje("Usuario registrado con éxito")
                        // Redirigir a la pantalla de inicio de sesión (MainActivity)
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Esto cierra la actividad actual para que el usuario no pueda regresar a la pantalla de registro presionando "Atrás"
                    } else {
                        // Error al registrar el usuario
                        mostrarMensaje("usuario ya esxiste")
                    }
                } else {
                    // El número de teléfono o correo ya existen
                    mostrarMensaje("Usuario ya existe")
                }
            } else {
                // Mostrar mensaje si algún campo está vacío
                mostrarMensaje("Por favor, complete todos los campos")
            }
        }

    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun registrarUsuario() {
        val nombre = editTextNombre.text.toString()
        val apellido = editTextApellido.text.toString()
        val telefono = editTextTelefono.text.toString()
        val correo = editTextCorreo.text.toString()
        val contrasena = editTextContrasena.text.toString()

        val db = DatabaseHandler(this)

        val nuevoUsuario = Usuario(
            nombre = nombre,
            apellido = apellido,
            telefono = telefono,
            correo = correo,
            contrasena = contrasena
        )

        val idNuevoUsuario = db.agregarUsuario(nuevoUsuario)

        if (idNuevoUsuario != -1L) {
            // Éxito al registrar el usuario

        } else {
            // Error al registrar el usuario
            Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
        }
    }
}


