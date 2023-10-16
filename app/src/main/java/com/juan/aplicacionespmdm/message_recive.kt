package com.juan.aplicacionespmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class message_recive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_recive)


        var btnSend = findViewById<Button>(R.id.buttonSend)
        var chat = findViewById<TextView>(R.id.Chat)
        var texto = findViewById<EditText>(R.id.textEdit)

        btnSend.setOnClickListener{
            if(texto.text.toString().isNotEmpty()){
                val intent = Intent(this, messageSending::class.java)
                intent.putExtra("Extra_reply", texto.text.toString())
                startActivity(intent)

                }
        }

        chat.setText( intent.extras?.getString("Extra_message").orEmpty())

    }
}