package com.juan.aplicacionespmdm.HelloApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.juan.aplicacionespmdm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSend = findViewById<Button>(R.id.buttonSend)
        var userText = findViewById<EditText>(R.id.etName)


        btnSend.setOnClickListener{
            var name = userText.text.toString()
            if (name.isNotEmpty()){
                var textIntent = Intent(this, secondActivity::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
            }

        }

    }
}