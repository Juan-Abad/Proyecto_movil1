package com.juan.aplicacionespmdm.ColorPalette

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juan.aplicacionespmdm.JuegoMesa.CategoriesViewHolder
import com.juan.aplicacionespmdm.JuegoMesa.GameCategory
import com.juan.aplicacionespmdm.R

class HorizontalPalette_Adapter (private val Palette_list: List<Palette> ) : RecyclerView.Adapter<HorizontalPalette_ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalPalette_ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_palette, parent, false)
        return HorizontalPalette_ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return Palette_list.size
    }

    override fun onBindViewHolder(holder: HorizontalPalette_ViewHolder, position: Int) {
        holder.render(Palette_list[position], position)
    }
}