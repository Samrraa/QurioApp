package com.samrraa.qurioapp.view.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.databinding.GameCardBinding
import com.samrraa.qurioapp.view.games.model.Game

class GameCardAdapter(
    private val items: List<Game>,
    private val onButtonClick: (Game) -> Unit
) : RecyclerView.Adapter<GameCardAdapter.GameCardViewHolder>() {

    inner class GameCardViewHolder(private val binding: GameCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            binding.textTitle.setText(game.title)
            binding.gameCardBackgroundView.setImage(game.imageRes)
            val color = ContextCompat.getColor(binding.root.context, game.borderColor)
            binding.gameCardBackgroundView.setBorderColor(color)
            binding.startGameButton.setOnClickListener {
                onButtonClick(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCardViewHolder {
        val binding = GameCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GameCardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: GameCardViewHolder, position: Int) {
        val game = items[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int = items.size
}