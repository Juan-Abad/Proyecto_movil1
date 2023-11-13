package com.juan.aplicacionespmdm.ColorPalette

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
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

        val rgBars = dialog.findViewById<RadioGroup>(R.id.rgBars)
        val rgColors = dialog.findViewById<RadioGroup>(R.id.rgColors)
        val cv_applyColor = dialog.findViewById<CardView>(R.id.cv_applyColor)

        val cv_H1 = findViewById<CardView>(R.id.cv_H1)
        val cv_H2 = findViewById<CardView>(R.id.cv_H2)
        val cv_H3 = findViewById<CardView>(R.id.cv_H3)

        val tv_CvH1 = findViewById<TextView>(R.id.tv_CvH1)
        val tv_CvH2 = findViewById<TextView>(R.id.tv_CvH2)
        val tv_CvH3 = findViewById<TextView>(R.id.tv_CvH3)

        cv_applyColor.setOnClickListener{
            val rdBarsSelectedId = rgBars.checkedRadioButtonId
            val rdBarsSelectedRadioButton: RadioButton = rgBars.findViewById(rdBarsSelectedId)

            val rdColorsSelectedId = rgColors.checkedRadioButtonId
            val rdColorsSelectedRadioButton: RadioButton = rgColors.findViewById(rdColorsSelectedId)

            val a = dialog.findViewById<TextView>(R.id.title_table_bars)

            if(rdBarsSelectedRadioButton.id.equals(tv_CvH1.id)) {
                a.setText("1")
            }

            when (rdBarsSelectedRadioButton.id) {
                tv_CvH1.id -> cv_H1.setCardBackgroundColor(rdColorsSelectedRadioButton.textColors)
                tv_CvH2.id -> cv_H2.setCardBackgroundColor(rdColorsSelectedRadioButton.textColors)
                tv_CvH3.id -> cv_H3.setCardBackgroundColor(rdColorsSelectedRadioButton.textColors)
                else -> {
                    for (i in 0 until palette_Adapter.itemCount) {
                        val viewHolder =
                            rv_palette.findViewHolderForAdapterPosition(i) as HorizontalPalette_ViewHolder // Asegúrate de reemplazar "YourViewHolder" por el nombre de tu ViewHolder
                        val recyclerViewTextView =
                            viewHolder.itemView.findViewById<TextView>(R.id.tv_Cv_ReciclerView) // Reemplaza "R.id.textViewInRecyclerView" con la ID correcta

                        if (rdBarsSelectedRadioButton.text.equals(recyclerViewTextView.text.toString())) {
                            (rv_palette.findViewHolderForAdapterPosition(viewHolder.adapterPosition)?.itemView?.findViewById<CardView>(R.id.cv_palette_RV))?.setCardBackgroundColor(rdColorsSelectedRadioButton.textColors)

                        }
                    }
                }
            }
        }
        dialog.show()
    }

}