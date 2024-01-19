package com.example.aplicationpetclass

import java.io.Serializable

data class Mascota(
    val idMascota: Long,
    val tipo: String,
    val nombre_mascota: String,
    val fecha_nacimiento: String,
    val sexo: String
) : Serializable