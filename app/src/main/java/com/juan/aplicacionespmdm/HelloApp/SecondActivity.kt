package com.juan.aplicacionespmdm.HelloApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.juan.aplicacionespmdm.R

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var textoHola = findViewById<TextView>(R.id.helloText)

        var nombre: String = intent.extras?.getString("extra_name").orEmpty()
        textoHola.setText("Hola $nombre")
    }
}