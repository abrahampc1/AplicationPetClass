package com.example.aplicationpetclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Alarm_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val img= findViewById<Button>(R.id.btnInicioAlarm)
        img.setOnClickListener{
            val lanzar69 = Intent(this, MainScreen::class.java)
            startActivity(lanzar69)
        }

        val img1= findViewById<Button>(R.id.btnPerfilAlarm)
        img1.setOnClickListener{
            val lanzar = Intent(this, Perfil_Activity::class.java)
            startActivity(lanzar)
        }

        val img2= findViewById<Button>(R.id.btnSaliralarm)
        img2.setOnClickListener{
            val lanzar3 = Intent(this, MainScreen::class.java)
            startActivity(lanzar3)
        }
    }
}