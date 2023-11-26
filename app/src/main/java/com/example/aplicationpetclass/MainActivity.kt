package com.example.aplicationpetclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import java.sql.PreparedStatement
import java.sql.SQLException

class MainActivity : AppCompatActivity() {

  /*  private var connectSQL=ConnectSQL()*/
    override fun onCreate(savedInstanceState: Bundle?) {



    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val button= findViewById<Button>(R.id.btnRegister)
    button.setOnClickListener{
      val lanzar = Intent(this, RegisterActivity::class.java)
      startActivity(lanzar)
    }


    val button1= findViewById<Button>(R.id.btnLogin)
    button1.setOnClickListener{
      val lanzar1 = Intent(this, MainScreen::class.java)
      startActivity(lanzar1)
    }



  }
}