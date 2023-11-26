package com.example.aplicationpetclass

// Usuario.kt

data class Usuario(
    val id: Int = -1,
    val nombre: String,
    val apellido: String,
    val telefono: String,
    val correo: String,
    val contrasena: String
)
