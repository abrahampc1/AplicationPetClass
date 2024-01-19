package com.example.aplicationpetclass

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UsuariosDB"
        private const val TABLE_NAME = "usuarios"
        private const val KEY_ID = "id"
        private const val KEY_NOMBRE = "nombre"
        private const val KEY_APELLIDO = "apellido"
        private const val KEY_TELEFONO = "telefono"
        private const val KEY_CORREO = "correo"
        private const val KEY_CONTRASENA = "contrasena"
        private const val TABLE_MASCOTAS = "mascotas"
        private const val KEY_ID_MASCOTA = "id_mascota"
        private const val KEY_TIPO = "tipo"
        private const val KEY_NOMBRE_MASCOTA = "nombre_mascota"
        private const val KEY_FECHA_NACIMIENTO = "fecha_nacimiento"
        private const val KEY_SEXO = "sexo"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableUsuarios = ("CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$KEY_NOMBRE TEXT, $KEY_APELLIDO TEXT, $KEY_TELEFONO TEXT, $KEY_CORREO TEXT, $KEY_CONTRASENA TEXT)")
        db.execSQL(createTableUsuarios)

        val createTableMascotas = ("CREATE TABLE $TABLE_MASCOTAS ($KEY_ID_MASCOTA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$KEY_TIPO TEXT, $KEY_NOMBRE_MASCOTA TEXT, $KEY_FECHA_NACIMIENTO TEXT, $KEY_SEXO TEXT, " +
                "$KEY_ID INTEGER, FOREIGN KEY($KEY_ID) REFERENCES $TABLE_NAME($KEY_ID))")
        db.execSQL(createTableMascotas)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MASCOTAS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun agregarUsuario(usuario: Usuario): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NOMBRE, usuario.nombre)
        values.put(KEY_APELLIDO, usuario.apellido)
        values.put(KEY_TELEFONO, usuario.telefono)
        values.put(KEY_CORREO, usuario.correo)
        values.put(KEY_CONTRASENA, usuario.contrasena)
        val resultado = db.insert(TABLE_NAME, null, values)
        db.close()
        return resultado
    }

    fun agregarMascota(mascota: Mascota, idUsuario: Long): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_TIPO, mascota.tipo)
        values.put(KEY_NOMBRE_MASCOTA, mascota.nombre_mascota)
        values.put(KEY_FECHA_NACIMIENTO, mascota.fecha_nacimiento)
        values.put(KEY_SEXO, mascota.sexo)
        values.put(KEY_ID, idUsuario)
        val resultado = db.insert(TABLE_MASCOTAS, null, values)
        db.close()
        return resultado
    }

    @SuppressLint("Range")
    fun obtenerMascotasPorUsuario(idUsuario: Long): List<Mascota> {
        val db = this.readableDatabase
        val mascotas = mutableListOf<Mascota>()

        val query = "SELECT * FROM $TABLE_MASCOTAS WHERE $KEY_ID = ?"
        val cursor = db.rawQuery(query, arrayOf(idUsuario.toString()))

        while (cursor.moveToNext()) {
            val idMascota = cursor.getLong(cursor.getColumnIndex(KEY_ID_MASCOTA))
            val tipo = cursor.getString(cursor.getColumnIndex(KEY_TIPO))
            val nombreMascota = cursor.getString(cursor.getColumnIndex(KEY_NOMBRE_MASCOTA))
            val fechaNacimiento = cursor.getString(cursor.getColumnIndex(KEY_FECHA_NACIMIENTO))
            val sexo = cursor.getString(cursor.getColumnIndex(KEY_SEXO))

            val mascota = Mascota(idMascota, tipo, nombreMascota, fechaNacimiento, sexo)
            mascotas.add(mascota)
        }

        cursor.close()
        return mascotas
    }

    fun existeTelefono(telefono: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $KEY_TELEFONO = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(telefono))
        val existe = cursor.count > 0
        cursor.close()
        return existe
    }

    fun existeCorreo(correo: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $KEY_CORREO = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(correo))
        val existe = cursor.count > 0
        cursor.close()
        return existe
    }

    fun verificarCredenciales(correo: String, contrasena: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $KEY_CORREO = ? AND $KEY_CONTRASENA = ?"
        val cursor = db.rawQuery(query, arrayOf(correo, contrasena))
        val existe = cursor.count > 0
        cursor.close()
        return existe
    }

    @SuppressLint("Range")
    fun obtenerDatosUsuarioPorCorreo(correoParam: String): Usuario? {
        val db = this.readableDatabase
        var usuario: Usuario? = null

        val query = "SELECT * FROM $TABLE_NAME WHERE $KEY_CORREO = ? OR $KEY_TELEFONO = ?"
        val cursor = db.rawQuery(query, arrayOf(correoParam))

        if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
            val nombre = cursor.getString(cursor.getColumnIndex(KEY_NOMBRE))
            val apellido = cursor.getString(cursor.getColumnIndex(KEY_APELLIDO))
            val correoBD = cursor.getString(cursor.getColumnIndex(KEY_CORREO))
            val telefonoBD = cursor.getString(cursor.getColumnIndex(KEY_TELEFONO))
            val contrasena = cursor.getString(cursor.getColumnIndex(KEY_CONTRASENA))

            usuario = Usuario(id, nombre, apellido, telefonoBD, correoBD, contrasena)
        }

        cursor.close()
        return usuario
    }

    // Agregar este método a tu clase DatabaseHandler
    fun usuarioTieneMascotas(idUsuario: Long): Boolean {
        val db = this.readableDatabase
        val query = "SELECT COUNT(*) FROM $TABLE_MASCOTAS WHERE $KEY_ID = ?"
        val cursor = db.rawQuery(query, arrayOf(idUsuario.toString()))

        cursor.use {
            return it.moveToFirst() && it.getInt(0) > 0
        }
    }

}
