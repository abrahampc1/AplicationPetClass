package com.example.aplicationpetclass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicationpetclass.DatabaseHandler
import com.example.aplicationpetclass.Mascota
import com.example.aplicationpetclass.R
import java.text.SimpleDateFormat
import java.util.*

class RegisterPetActivity : AppCompatActivity() {

    private lateinit var editTextPetName: EditText
    private lateinit var spinnerPetType: Spinner
    private lateinit var editTextPetBirthDate: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var btnRegisterPet: Button
    private lateinit var btnSalir: Button

    private val idUsuarioActual: Long by lazy {
        obtenerIdUsuarioLogueado()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_pet)

        editTextPetName = findViewById(R.id.editTextPetName)
        spinnerPetType = findViewById(R.id.spinnerPetType)
        editTextPetBirthDate = findViewById(R.id.editTextPetBirthDate)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        btnRegisterPet = findViewById(R.id.btnRegisterPet)
        btnSalir = findViewById(R.id.btnSalirRegisterPet)

        btnRegisterPet.setOnClickListener {
            registrarMascota()
        }

        btnSalir.setOnClickListener {
            val lanzar = Intent(this, MainScreen::class.java)
            startActivity(lanzar)
        }
    }

    private fun registrarMascota() {
        val nombreMascota = editTextPetName.text.toString()
        val tipoMascota = spinnerPetType.selectedItem.toString()
        val fechaNacimiento = editTextPetBirthDate.text.toString()
        val sexoMascota = obtenerSexoSeleccionado()

        if (nombreMascota.isNotEmpty() && tipoMascota.isNotEmpty() && fechaNacimiento.isNotEmpty() && sexoMascota.isNotEmpty()) {
            val mascota = Mascota(
                idMascota = 0,
                tipo = tipoMascota,
                nombre_mascota = nombreMascota,
                fecha_nacimiento = fechaNacimiento,
                sexo = sexoMascota
            )

            val dbHandler = DatabaseHandler(this)

            // Agregar la mascota a la base de datos
            val resultado = dbHandler.agregarMascota(mascota, idUsuarioActual)

            if (resultado != -1L) {
                Toast.makeText(this, "Mascota registrada con éxito", Toast.LENGTH_SHORT).show()
                // Puedes agregar más lógica aquí, como navegar a otra actividad
            } else {
                Toast.makeText(this, "Error al registrar la mascota", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun obtenerSexoSeleccionado(): String {
        val selectedId = radioGroupGender.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedId)
        return radioButton?.text.toString()
    }

    private fun obtenerIdUsuarioLogueado(): Long {
        // Asumiendo que estás utilizando SharedPreferences para almacenar el ID del usuario
        val sharedPreferences = getSharedPreferences("Usuario", MODE_PRIVATE)
        return sharedPreferences.getInt("id", -1).toLong() // -1 como valor predeterminado si no se encuentra
    }
}
