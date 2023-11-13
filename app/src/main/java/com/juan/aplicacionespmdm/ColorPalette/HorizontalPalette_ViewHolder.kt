package com.juan.aplicacionespmdm.ColorPalette

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.juan.aplicacionespmdm.R


class HorizontalPalette_ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val cv_palette: CardView = view.findViewById(R.id.cv_palette_RV)
    private val tv_palette: TextView = view.findViewById(R.id.tv_Cv_ReciclerView)
    fun render(palette_list: Palette, position: Int) {
        cv_palette.setBackgroundColor(palette_list.color)
        var position_final = position+1
        tv_palette.setText("V$position_final (${palette_list.opacity}%)")
    }
}
