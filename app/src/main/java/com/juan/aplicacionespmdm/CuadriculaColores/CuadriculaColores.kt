package com.juan.aplicacionespmdm.CuadriculaColores

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.juan.aplicacionespmdm.R

class CuadriculaColores : AppCompatActivity() {

    private lateinit var tv_layout1: TextView
    private lateinit var tv_layout2: TextView
    private lateinit var tv_layout3: TextView
    private lateinit var tv_layout4: TextView
    private lateinit var tv_layout5: TextView
    private lateinit var tv_layout6: TextView
    private lateinit var tv_layout7: TextView
    private lateinit var tv_layout8: TextView
    private lateinit var tv_layout9: TextView
    private lateinit var tv_layout10: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuadricula_colores)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        tv_layout1 = findViewById<TextView>(R.id.tv_layout1)
        tv_layout2 = findViewById<TextView>(R.id.tv_layout2_1)
        tv_layout3 = findViewById<TextView>(R.id.tv_layout2_2_1_1)
        tv_layout4 = findViewById<TextView>(R.id.tv_layout2_2_1_2)
        tv_layout5 = findViewById<TextView>(R.id.tv_layout2_2)
        tv_layout6 = findViewById<TextView>(R.id.tv_layout3_1_1)
        tv_layout7 = findViewById<TextView>(R.id.tv_layout3_1_2_1)
        tv_layout8 = findViewById<TextView>(R.id.tv_layout3_1_2_2)
        tv_layout9 = findViewById<TextView>(R.id.tv_layout3_2_1)
        tv_layout10 = findViewById<TextView>(R.id.tv_layout3_2_2)
    }

    private fun initListeners() {
        tv_layout1.setOnClickListener { showDialog(tv_layout1) }
        tv_layout2.setOnClickListener { showDialog(tv_layout2) }
        tv_layout3.setOnClickListener { showDialog(tv_layout3) }
        tv_layout4.setOnClickListener { showDialog(tv_layout4) }
        tv_layout5.setOnClickListener { showDialog(tv_layout5) }
        tv_layout6.setOnClickListener { showDialog(tv_layout6) }
        tv_layout7.setOnClickListener { showDialog(tv_layout7) }
        tv_layout8.setOnClickListener { showDialog(tv_layout8) }
        tv_layout9.setOnClickListener { showDialog(tv_layout9) }
        tv_layout10.setOnClickListener { showDialog(tv_layout10) }
    }

    private fun showDialog(tv: TextView) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_cc_change_color)

        val textView = tv

        var rgColors_cc = dialog.findViewById<RadioGroup>(R.id.rgColors_cc)
        val cv_applyColor = dialog.findViewById<CardView>(R.id.cv_applyColor)

        cv_applyColor.setOnClickListener {
            val rdColorsSelectedId = rgColors_cc.checkedRadioButtonId
            val rdColorsSelectedRadioButton: RadioButton = rgColors_cc.findViewById(rdColorsSelectedId)

            when (rdColorsSelectedRadioButton.text) {
                getString(R.string.White) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.white))
                    textView.setText("Blanco")
                    textView.setTextColor(getResources().getColor(R.color.black))
                }

                getString(R.string.Red) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_rojo))
                    textView.setText("Rojo")
                    textView.setTextColor(getResources().getColor(R.color.white))
                }

                getString(R.string.Orange) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_naranja))
                    textView.setText("Naraja")
                    textView.setTextColor(getResources().getColor(R.color.black))
                }

                getString(R.string.Yellow) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_amarillo))
                    textView.setText("Amarillo")
                    textView.setTextColor(getResources().getColor(R.color.black))
                }

                getString(R.string.Green) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_verde))
                    textView.setText("Verde")
                    textView.setTextColor(getResources().getColor(R.color.black))
                }

                getString(R.string.Cyan) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_cian))
                    textView.setText("Cián")
                    textView.setTextColor(getResources().getColor(R.color.black))
                }

                getString(R.string.Blue) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_azul))
                    textView.setText("Azul")
                    textView.setTextColor(getResources().getColor(R.color.white))
                }

                getString(R.string.Violet) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_violeta))
                    textView.setText("Violeta")
                    textView.setTextColor(getResources().getColor(R.color.white))
                }

                getString(R.string.Grey) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_gris))
                    textView.setText("Gris")
                    textView.setTextColor(getResources().getColor(R.color.white))
                }

                getString(R.string.Black) -> {
                    textView.setBackgroundColor(getResources().getColor(R.color.CC_negro))
                    textView.setText("Negro")
                    textView.setTextColor(getResources().getColor(R.color.white))
                }
            }
            dialog.hide()
        }
        dialog.show()
    }
}