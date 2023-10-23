package com.juan.aplicacionespmdm.JuegoMesa

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.juan.aplicacionespmdm.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)
    fun render(gameCategory: GameCategory, onItemSelected: (Int) -> Unit) {
        when (gameCategory) {
            GameCategory.Cooperative -> {
                tvCategoryName.text = "Cooperativos"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }

            GameCategory.Deckbuilding -> {
                tvCategoryName.text = "Deckbuilding"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }

            GameCategory.Euro -> {
                tvCategoryName.text = "Euro"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }

            GameCategory.LCG -> {
                tvCategoryName.text = "LCG"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }

            GameCategory.Legacy -> {
                tvCategoryName.text = "Legacy"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }
        }
    }

}
