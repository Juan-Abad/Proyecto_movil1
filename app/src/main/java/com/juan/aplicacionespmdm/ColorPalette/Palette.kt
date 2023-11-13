package com.juan.aplicacionespmdm.ColorPalette

import android.graphics.Color

data class Palette (val name:String, var color: Int, val opacity: Int){
    fun updateColor(newColor: Int) {
        color = newColor
    }
}