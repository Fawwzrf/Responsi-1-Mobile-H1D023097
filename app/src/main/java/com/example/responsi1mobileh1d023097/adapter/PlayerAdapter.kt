package com.example.responsi1mobileh1d023097.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023097.data.model.Player
import com.example.responsi1mobileh1d023097.databinding.ItemPlayerBinding

class PlayerAdapter(
    private var players: List<Player>,
    private val clickListener: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
    private fun getCardColor(position: String): Int {
        return when {
            position.contains("Goalkeeper", ignoreCase = true) -> Color.parseColor("#FFC107")
            position.contains("Defence", ignoreCase = true) ||
                    position.contains("Back", ignoreCase = true) -> Color.parseColor("#2196F3")
            position.contains("Midfield", ignoreCase = true) -> Color.parseColor("#4CAF50")
            position.contains("Offence", ignoreCase = true) ||
                    position.contains("Winger", ignoreCase = true) ||
                    position.contains("Forward", ignoreCase = true) -> Color.parseColor("#F44336")
            else -> Color.LTGRAY
        }
    }

    private fun getTextColor(backgroundColor: Int): Int {
        return if (backgroundColor == Color.parseColor("#FFC107") || backgroundColor == Color.parseColor("#4CAF50")) {
            Color.BLACK
        } else {
            Color.WHITE
        }
    }


    inner class PlayerViewHolder(private val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player) {

            binding.tvPlayerName.text = player.name
            binding.tvPlayerNationality.text = player.nationality

            val bgColor = getCardColor(player.position)
            val textColor = getTextColor(bgColor)

            binding.cardPlayer.setCardBackgroundColor(bgColor)
            binding.tvPlayerName.setTextColor(textColor)
            binding.tvPlayerNationality.setTextColor(textColor)

            binding.cardPlayer.setOnClickListener {
                clickListener(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int = players.size

    fun updateData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}