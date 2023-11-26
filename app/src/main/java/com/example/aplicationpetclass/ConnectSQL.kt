
/*
package com.example.aplicationpetclass

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.SQLException

class ConnectSQL {
    private val ip="192.168.1.8:1433"
    private val db="PetClass_app_new"
    private val username="user"
    private val password="1234"

    fun doConn() {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        val connString : String
        val any = try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            connString = "jdbc:jtds:sqlserver://$ip;database=$db;user=$username;passwoord=$password"
        } catch (ex: SQLException) {

            Log.e("Error:", ex.message!!)
        } catch (ex1: ClassNotFoundException) {
            Log.e("Error: ", ex1.message!!)
        } catch (ex2: ClassNotFoundException) {
            Log.e("Error: ", ex2.message!!)

        }
    }

    fun dbConn(): Any {

    }
}
*/