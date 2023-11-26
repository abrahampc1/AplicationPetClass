package com.example.aplicationpetclass

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class RegisterActivity<FirebaseUser> : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txt= findViewById<TextView>(R.id.txtIniciaSesionRegister)
        txt.setOnClickListener{
            val lanzar3 = Intent(this, MainActivity::class.java)
            startActivity(lanzar3)
        }



    }
}


