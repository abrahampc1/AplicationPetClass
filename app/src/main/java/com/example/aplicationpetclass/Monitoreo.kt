package com.example.aplicationpetclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlin.random.Random

class Monitoreo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoreo)

        val salir= findViewById<Button>(R.id.btnSalirMonitoreoMonitoreo)
        salir.setOnClickListener{
            val lanzar69 = Intent(this, MainScreen::class.java)
            startActivity(lanzar69)
        }

        val monitoreo = findViewById<Button>(R.id.btnMoniteoreoPantalla)
        monitoreo.setOnClickListener {
            // Encuentra los EditText por sus IDs
            val pulsocardiaco = findViewById<EditText>(R.id.editTextPulsoCardiacoMonitoreo)
            val oxigenacion = findViewById<EditText>(R.id.editTextNivelOxiMonitoreo)
            val nombre = findViewById<EditText>(R.id.editTextNombreMascotaMonitoreo)

            // Generar valores aleatorios para pulso cardíaco y oxigenación
            val randomPulso = Random.nextInt(80, 121)
            val randomOxigenacion = Random.nextInt(80, 121)


            // Hacer los EditText no editables
            pulsocardiaco.isFocusable = false
            pulsocardiaco.isFocusableInTouchMode = false
            pulsocardiaco.inputType = InputType.TYPE_NULL

            oxigenacion.isFocusable = false
            oxigenacion.isFocusableInTouchMode = false
            oxigenacion.inputType = InputType.TYPE_NULL


            // Establecer los valores aleatorios en los EditText
            pulsocardiaco.setText(randomPulso.toString())
            oxigenacion.setText(randomOxigenacion.toString())

            // Cambia los valores de los EditText

            nombre.setText("Mimí")
        }

    }
}