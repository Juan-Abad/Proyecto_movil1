package com.juan.aplicacionespmdm.IMCapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import com.juan.aplicacionespmdm.HelloApp.MainActivity
import com.juan.aplicacionespmdm.HelloApp.secondActivity
import com.juan.aplicacionespmdm.R
import java.lang.Math.pow
import java.text.DecimalFormat
import kotlin.math.pow

class IMCapp : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private var currentHeight: Int = 120
    private var currentWeight: Int = 70
    private var currentAge: Int = 30



    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView


    private lateinit var numPeso: TextView
    private lateinit var numEdad: TextView

    private lateinit var btnmenosPeso: Button
    private lateinit var btnmasPeso: Button
    private lateinit var btnmenosEdad: Button
    private lateinit var btnmasEdad: Button


    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView


    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcapp)

        initComponents()
        initListeners()
        setWeight()
        setAge()
        print("hola")

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)


        rsHeight = findViewById<RangeSlider>(R.id.rsHeight)
        tvHeight = findViewById<TextView>(R.id.tvHeight)


        numPeso = findViewById<TextView>(R.id.numPeso)
        numEdad = findViewById<TextView>(R.id.numEdad)

        btnmenosPeso = findViewById<Button>(R.id.btnmenosPeso)
        btnmasPeso = findViewById<Button>(R.id.btnmasPeso)
        btnmenosEdad = findViewById<Button>(R.id.btnmenosEdad)
        btnmasEdad = findViewById<Button>(R.id.btnmasEdad)


        btnCalcular = findViewById(R.id.btnCalcuar)

    }
    private fun initListeners() {
        viewMale.setOnClickListener{ setComponentColorMale()}
        viewFemale.setOnClickListener{ setComponentColorFemale()}


        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            val result = df.format(value)
            tvHeight.text = "$result cm"
            currentHeight = value.toInt()
        }


        btnmenosPeso.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnmasPeso.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnmenosEdad.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnmasEdad.setOnClickListener {
            currentAge += 1
            setAge()
        }


        btnCalcular.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }


    }
    private fun setComponentColorMale () {
        if (!isMaleSelected){
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }
    private fun setComponentColorFemale () {
        if (!isFemaleSelected){
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            isMaleSelected = false
            isFemaleSelected = true
        }
    }
    private fun setWeight() { numPeso.text = currentWeight.toString() }
    private fun setAge() { numEdad.text = currentAge.toString()}

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100).pow(2.0)

        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double){
        var intent = Intent(this, resultActivity::class.java)
        intent.putExtra("Extra_result", result)
        startActivity(intent)
    }


}
