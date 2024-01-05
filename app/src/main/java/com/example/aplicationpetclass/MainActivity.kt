package com.example.aplicationpetclass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// MainActivity
class MainActivity : AppCompatActivity() {

  private lateinit var editTextCorreoLogin: EditText
  private lateinit var editTextContrasenaLogin: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val btnInicioSesion = findViewById<Button>(R.id.btnLogin)
    editTextCorreoLogin = findViewById(R.id.editTextCorreoLogin)
    editTextContrasenaLogin = findViewById(R.id.editTextTextPassword)

    val button = findViewById<Button>(R.id.btnRegister)
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
          val usuario = db.obtenerDatosUsuarioPorCorreo(correo) // Obtener datos del usuario

          // Guardar los datos del usuario en SharedPreferences
          guardarDatosUsuario(usuario)

          val intent = Intent(this, MainScreen::class.java)
          startActivity(intent)
        } else {
          mostrarMensaje("Correo o contraseña incorrectas")
        }
      } else {
        mostrarMensaje("Por favor, complete todos los campos")
      }
    }
  }

  private fun guardarDatosUsuario(usuario: Usuario?) {
    usuario?.let {
      val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
      val editor = sharedPreferences.edit()
      editor.putInt("id", usuario.id)
      editor.putString("nombre", usuario.nombre)
      editor.putString("apellido", usuario.apellido)
      editor.putString("telefono", usuario.telefono)
      editor.putString("correo", usuario.correo)
      editor.putString("contrasena", usuario.contrasena)
      editor.apply()
    }
  }

  private fun mostrarMensaje(mensaje: String) {
    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
  }
}