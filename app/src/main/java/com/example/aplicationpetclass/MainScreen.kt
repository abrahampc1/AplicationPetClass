package com.example.aplicationpetclass

import GPS_Activity
import Health_Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)




        val button2= findViewById<Button>(R.id.btnSalir)
        button2.setOnClickListener{
            val lanzar3 = Intent(this, MainActivity::class.java)
            startActivity(lanzar3)
        }



        val button4= findViewById<ImageView>(R.id.imgGPS)
        button4.setOnClickListener{
            val lanzar = Intent(this, MapsActivity::class.java)
            startActivity(lanzar)
        }

        val img= findViewById<ImageView>(R.id.imgCerrarSesion)
        img.setOnClickListener{
            val lanzar69 = Intent(this, MainActivity::class.java)
            startActivity(lanzar69)
        }

        val img1= findViewById<ImageView>(R.id.imgAlarm)
        img1.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/impetclass/")) // Aquí cambia la URL a la de Facebook u otro sitio web
            startActivity(intent)
        }

        val img2= findViewById<ImageView>(R.id.imgEmergency)
        img2.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/veterinario/@24.7703655,-107.4189796,16.59z?hl=es-419&entry=ttu"))
            startActivity(intent)
        }

        val img67= findViewById<ImageView>(R.id.imgHealth)
        img67.setOnClickListener{
            val lanzar0 = Intent(this, Monitoreo::class.java)
            startActivity(lanzar0)
        }

    }
}

