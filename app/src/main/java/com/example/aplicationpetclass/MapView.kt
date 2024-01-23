package com.example.aplicationpetclass


import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MapView : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)
        // Obtén una referencia al WebView en el diseño
        webView = findViewById(R.id.webView)

        // Configura las opciones del WebView
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // Habilita JavaScript

        // Carga una URL en el WebView
        webView.loadUrl("https://www.instagram.com/impetclass/")
    }
}
