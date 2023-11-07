package com.juan.aplicacionespmdm.ColorPalette

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juan.aplicacionespmdm.R

class ColorPalette : AppCompatActivity() {

    private lateinit var rv_palette: RecyclerView

    private lateinit var palette_Adapter: HorizontalPalette_Adapter

    private lateinit var cv_changeColor: CardView

    private var palette = mutableListOf(
        Palette("verde", 123, 30)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_palette)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rv_palette = findViewById<RecyclerView>(R.id.rv_color_palette)
        cv_changeColor = findViewById(R.id.cv_changeColor)
    }

    private fun initUI(){
        palette_Adapter = HorizontalPalette_Adapter(palette)

        rv_palette.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_palette.adapter = palette_Adapter
    }

    private fun initListeners() {
        cv_changeColor.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_change_color)

        val rgBars = findViewById<RadioGroup>(R.id.rgBars)
        val rgColors = findViewById<RadioGroup>(R.id.rgColors)
        val cv_applyColor = findViewById<CardView>(R.id.cv_applyColor)

        dialog.show()
    }

}