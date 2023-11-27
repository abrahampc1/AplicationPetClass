package com.example.aplicationpetclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)


        val button1= findViewById<Button>(R.id.btnInicio)
        button1.setOnClickListener{
            val lanzar2 = Intent(this, MainScreen::class.java)
            startActivity(lanzar2)
        }

        val button2= findViewById<Button>(R.id.btnSalir)
        button2.setOnClickListener{
            val lanzar3 = Intent(this, MainActivity::class.java)
            startActivity(lanzar3)
        }

        val button3= findViewById<Button>(R.id.btnPerfil)
        button3.setOnClickListener{
            val lanzar3 = Intent(this, Perfil_Activity::class.java)
            startActivity(lanzar3)
        }

        val button4= findViewById<ImageView>(R.id.imgGPS)
        button4.setOnClickListener{
            val lanzar = Intent(this, GPS_Activity::class.java)
            startActivity(lanzar)
        }


        val img= findViewById<ImageView>(R.id.imgCerrarSesion)
        img.setOnClickListener{
            val lanzar69 = Intent(this, MainActivity::class.java)
            startActivity(lanzar69)
        }

        }
}

