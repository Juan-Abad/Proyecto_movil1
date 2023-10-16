package com.juan.aplicacionespmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class messageSending : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_sending)



        val btnSend = findViewById<Button>(R.id.buttonSend)
        var chat = findViewById<TextView>(R.id.Chat)
        var texto = findViewById<EditText>(R.id.textEdit)

        btnSend.setOnClickListener{
            if(texto.text.toString().isNotEmpty()){
                val intent = Intent(this, message_recive::class.java)
                intent.putExtra("Extra_message", texto.text.toString())
                startActivity(intent)
            }
        }

        var tvReplyReceived = findViewById<TextView>(R.id.textview_title)
        var reply: String = intent.extras?.getString("Extra_reply").orEmpty()
        if(reply.isNotEmpty()){
            chat.text = reply
            tvReplyReceived.text = "Reply Received"
        }
    }

}