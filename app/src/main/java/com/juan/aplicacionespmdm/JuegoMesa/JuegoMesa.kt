package com.juan.aplicacionespmdm.JuegoMesa

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.juan.aplicacionespmdm.R

class JuegoMesa : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter

    private lateinit var fabAddGame: FloatingActionButton

    private var etGame: EditText? = null
    private var rgCategories: RadioGroup? = null
    private var btnAddGame: Button? = null


    private val categories = listOf(
        GameCategory.Cooperative,
        GameCategory.Deckbuilding,
        GameCategory.Euro,
        GameCategory.LCG,
        GameCategory.Legacy
    )
    private var games = mutableListOf(
        Game("Frostpunk", GameCategory.Cooperative),
        Game("Hero Realm", GameCategory.Deckbuilding),
        Game("Agrícola", GameCategory.Euro),
        Game("Arkam Horror", GameCategory.LCG),
        Game("Gloohaven", GameCategory.Legacy)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_mesa)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
        etGame = findViewById<EditText>(R.id.etGame)
        rgCategories = findViewById<RadioGroup>(R.id.rgCategories)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {position -> onCategorieSelected(position)}
        gamesAdapter = GamesAdapter(games) {position -> onGameSelected(position)}

        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rvCategories.adapter = categoriesAdapter

        rvGames.layoutManager = LinearLayoutManager(this)
        rvGames.adapter = gamesAdapter
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if (currentGame.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when (selectedRadioButton.text) {
                    getString(R.string.dialog_cooperative_category) -> GameCategory.Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> GameCategory.Deckbuilding
                    getString(R.string.dialog_euro_category) -> GameCategory.Euro
                    getString(R.string.dialog_lcg_category) -> GameCategory.LCG
                    else -> GameCategory.Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun updateGames() {
        val selectedCategories: List<GameCategory> = categories.filter { it.isSelected }
        val newGames = games.filter { selectedCategories.contains(it.category) }
        gamesAdapter.games = newGames

        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position: Int) {
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }

    private fun onCategorieSelected(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)

        updateGames()
    }


}