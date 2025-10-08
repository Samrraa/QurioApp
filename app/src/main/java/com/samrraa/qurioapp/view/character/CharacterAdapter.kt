package com.samrraa.qurioapp.view.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.databinding.ChosenCharacterBinding
import com.samrraa.qurioapp.databinding.LockedCharacterBinding
import com.samrraa.qurioapp.databinding.OpenedCharacterBinding
import com.samrraa.qurioapp.model.CharacterDisplayState
import com.samrraa.qurioapp.model.CharacterUi

class CharacterAdapter(
    val items: MutableList<CharacterUi>,
    private val clickListener: CharacterClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            CharacterDisplayState.CHOSEN.ordinal -> {
                val binding = ChosenCharacterBinding.inflate(inflater, parent, false)
                ChosenViewHolder(binding)
            }

            CharacterDisplayState.OPENED.ordinal -> {
                val binding = OpenedCharacterBinding.inflate(inflater, parent, false)
                OpenedViewHolder(binding)
            }

            else -> {
                val binding = LockedCharacterBinding.inflate(inflater, parent, false)
                LockedViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is ChosenViewHolder -> holder.bind(item)
            is OpenedViewHolder -> holder.bind(item)
            is LockedViewHolder -> holder.bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int = items[position].state.ordinal

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<CharacterUi>) {
        val diffCallback = CharacterDiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ChosenViewHolder(
        private val binding: ChosenCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterUi: CharacterUi) {
            binding.characterName.text = characterUi.displayName
            binding.characterImage.setImageResource(characterUi.characterImageRes)
            binding.root.setOnClickListener {
                clickListener.openDetails(characterUi)
            }
        }
    }

    inner class OpenedViewHolder(
        private val binding: OpenedCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterUi: CharacterUi) {
            binding.characterName.text = characterUi.displayName
            binding.characterImage.setImageResource(characterUi.characterImageRes)

            binding.root.setOnClickListener {
                clickListener.chooseCharacter(characterUi)
            }
        }
    }

    inner class LockedViewHolder(
        private val binding: LockedCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterUi: CharacterUi) {
            binding.characterName.text = characterUi.displayName
            binding.characterImage.setImageResource(characterUi.characterImageRes)
            binding.characterPrice.text = characterUi.price
            binding.root.setOnClickListener {
                clickListener.openDetails(characterUi)
            }
        }
    }

    private class CharacterDiffCallback(
        private val oldList: List<CharacterUi>,
        private val newList: List<CharacterUi>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].displayName == newList[newItemPosition].displayName
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }

    interface CharacterClickListener {
        fun chooseCharacter(characterUi: CharacterUi)
        fun openDetails(characterUi: CharacterUi)
    }
}
