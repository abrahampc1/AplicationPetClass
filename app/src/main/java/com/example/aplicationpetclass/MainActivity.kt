package com.example.aplicationpetclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

  private lateinit var editTextCorreoLogin: EditText
  private lateinit var editTextContrasenaLogin: EditText

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val btnInicioSesion = findViewById<Button>(R.id.btnLogin)

    editTextCorreoLogin = findViewById(R.id.editTextCorreoLogin)
    editTextContrasenaLogin = findViewById(R.id.editTextTextPassword)

    val button= findViewById<Button>(R.id.btnRegister)
    button.setOnClickListener{
      val lanzar = Intent(this, RegisterActivity::class.java)
      startActivity(lanzar)
    }


    btnInicioSesion.setOnClickListener {
      val correo = editTextCorreoLogin.text.toString()
      val contrasena = editTextContrasenaLogin.text.toString()

      if (correo.isNotBlank() && contrasena.isNotBlank()) {
        val db = DatabaseHandler(this)

        if (db.verificarCredenciales(correo, contrasena)) {
          // Las credenciales son correctas, el usuario puede iniciar sesión
          mostrarMensaje("Inicio de sesión exitoso")
          // Aquí puedes navegar a la siguiente pantalla o realizar acciones necesarias
          val lanzar2 = Intent(this, MainScreen::class.java)
          startActivity(lanzar2)


        } else {
          // Las credenciales no coinciden o no existen en la base de datos
          mostrarMensaje("Correo o contraseña incorrectas")
        }
      } else {
        mostrarMensaje("Por favor, complete todos los campos")
      }
    }
  }

  private fun mostrarMensaje(mensaje: String) {
    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
  }
}