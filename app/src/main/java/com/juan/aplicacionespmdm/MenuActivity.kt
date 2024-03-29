package com.juan.aplicacionespmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.juan.aplicacionespmdm.ColorPalette.ColorPalette
import com.juan.aplicacionespmdm.HelloApp.MainActivity
import com.juan.aplicacionespmdm.IMCapp.IMCapp
import com.juan.aplicacionespmdm.JuegoMesa.JuegoMesa
import com.juan.aplicacionespmdm.SuperheroApp.SuperheroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnIMCapp = findViewById<Button>(R.id.btnIMCapp)
        var btnJuegoMesa = findViewById<Button>(R.id.btnJuegoMesa)
        var btnColorPalette = findViewById<Button>(R.id.btnColorPalette)
        var btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)

        btnHelloApp.setOnClickListener{navigateToHelloApp()}
        btnMessageApp.setOnClickListener{navigateToMessageSending()}
        btnIMCapp.setOnClickListener{navigateToIMCapp()}
        btnJuegoMesa.setOnClickListener{navigateToJuegoMesa()}
        btnColorPalette.setOnClickListener{navigateToColorPalette()}
        btnSuperheroApp.setOnClickListener{navigateToSuperheroApp()}
    }
    private fun navigateToHelloApp(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToMessageSending(){
        var intent = Intent(this, messageSending::class.java)
        startActivity(intent)
    }
    private fun navigateToIMCapp(){
        var intent = Intent(this, IMCapp::class.java)
        startActivity(intent)
    }
    private fun navigateToJuegoMesa(){
        var intent = Intent(this, JuegoMesa::class.java)
        startActivity(intent)
    }
    private fun navigateToColorPalette(){
        var intent = Intent(this, ColorPalette::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperheroApp(){
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }
}