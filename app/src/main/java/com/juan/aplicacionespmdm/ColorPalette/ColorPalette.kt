package com.juan.aplicacionespmdm.ColorPalette

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juan.aplicacionespmdm.R
import kotlin.math.absoluteValue

class ColorPalette : AppCompatActivity() {

    private lateinit var rv_palette: RecyclerView

    private lateinit var palette_Adapter: HorizontalPalette_Adapter

    private lateinit var cv_changeColor: CardView

    private var palette = mutableListOf(
        Palette("V1", 0x33fffd80.toInt(), 20),
        Palette("V2", 0x59ffc87a.toInt(), 35),
        Palette("V3", 0x80fffc33.toInt(), 50),
        Palette("V4", 0xA60000FF.toInt(), 65),
        Palette("V5", 0xCC800080.toInt(), 80)
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
        /*  Este codigo permite cambiar la separación entre los items del recyclerView
        val itemDecorator = HorizontalItemSeparation(10)
        rv_palette.addItemDecoration(itemDecorator)
        */
        cv_changeColor = findViewById(R.id.cv_changeColor)
    }

    private fun initUI() {
        palette_Adapter = HorizontalPalette_Adapter(palette)

        rv_palette.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_palette.adapter = palette_Adapter
    }

    private fun initListeners() {
        cv_changeColor.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_change_color)

        val rgBars = dialog.findViewById<RadioGroup>(R.id.rgBars)
        val rgColors = dialog.findViewById<RadioGroup>(R.id.rgColors)
        val cv_applyColor = dialog.findViewById<CardView>(R.id.cv_applyColor)

        val cv_H1 = findViewById<CardView>(R.id.cv_H1)
        val cv_H2 = findViewById<CardView>(R.id.cv_H2)
        val cv_H3 = findViewById<CardView>(R.id.cv_H3)

        val tv_CvH1 = findViewById<TextView>(R.id.tv_CvH1)
        val tv_CvH2 = findViewById<TextView>(R.id.tv_CvH2)
        val tv_CvH3 = findViewById<TextView>(R.id.tv_CvH3)

        cv_applyColor.setOnClickListener {
            val rdBarsSelectedId = rgBars.checkedRadioButtonId
            val rdBarsSelectedRadioButton: RadioButton = rgBars.findViewById(rdBarsSelectedId)

            val rdColorsSelectedId = rgColors.checkedRadioButtonId
            val rdColorsSelectedRadioButton: RadioButton = rgColors.findViewById(rdColorsSelectedId)

            val a = dialog.findViewById<TextView>(R.id.title_table_bars)

            var colorFondo: String = ""

            when (rdColorsSelectedRadioButton.text) {
                getString(R.string.White) -> colorFondo = "FFFFFF"
                getString(R.string.Red) -> colorFondo = "FF0000"
                getString(R.string.Orange) -> colorFondo = "FFA500"
                getString(R.string.Yellow) -> colorFondo = "FFFF00"
                getString(R.string.Green) -> colorFondo = "00FF00"
                getString(R.string.Cyan) -> colorFondo = "00FFFF"
                getString(R.string.Blue) -> colorFondo = "0000FF"
                getString(R.string.Violet) -> colorFondo = "FF00FF"
                getString(R.string.Black) -> colorFondo = "000000"
            }
            when (rdBarsSelectedRadioButton.text) {
                tv_CvH1.text -> cv_H1.setBackgroundColor(("33$colorFondo").toLong(radix = 16).toInt())
                tv_CvH2.text -> cv_H2.setBackgroundColor(("80$colorFondo").toLong(radix = 16).toInt())
                tv_CvH3.text -> cv_H3.setBackgroundColor(("CC$colorFondo").toLong(radix = 16).toInt())
                else -> {
                    for (i in 0 until palette_Adapter.itemCount) {
                        val viewHolder = rv_palette.findViewHolderForAdapterPosition(i) as? HorizontalPalette_ViewHolder
                        val recyclerViewTextView = viewHolder?.itemView?.findViewById<TextView>(R.id.tv_Cv_ReciclerView)

                        var opacidad: String = ""

                        if (recyclerViewTextView != null) {
                            when(recyclerViewTextView.text.substring(recyclerViewTextView.length()-4 , recyclerViewTextView.length()-2)) {
                                "20" -> opacidad = "33"
                                "50" -> opacidad = "80"
                                "80" -> opacidad = "CC"
                                "35" -> opacidad = "59"
                                "65" -> opacidad = "A6"
                            }
                            System.out.println(rdBarsSelectedRadioButton.text)
                            System.out.println(recyclerViewTextView.text)
                            if (rdBarsSelectedRadioButton.text.equals(recyclerViewTextView.text)) {
                                val newColor = (opacidad + colorFondo).toLong(radix = 16).toInt()
                                palette[i].updateColor(newColor)
                                palette_Adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
            dialog.hide()
        }
        dialog.show()
    }

}