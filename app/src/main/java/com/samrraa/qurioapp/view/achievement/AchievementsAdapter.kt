package com.samrraa.qurioapp.view.achievement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.databinding.AchievementItemBinding
import com.samrraa.qurioapp.model.AchievementUi

class AchievementsAdapter(
    val items: MutableList<AchievementUi>,
    private val clickListener: AchievementsClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> {
                val binding = AchievementItemBinding.inflate(inflater, parent, false)
                AchievedViewHolder(binding)
            }

            else -> {
                val binding = AchievementItemBinding.inflate(inflater, parent, false)
                UnAchievedViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val item = items[position]
        when (holder) {
            is AchievedViewHolder -> holder.bind(item)
            is UnAchievedViewHolder -> holder.bind(item)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class AchievedViewHolder(
        private val binding: AchievementItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(achievementUi: AchievementUi) {
            binding.achievementName.text = achievementUi.title
            binding.achievementImage.setImageResource(achievementUi.achievementImageRes)
            binding.root.setOnClickListener {
                clickListener.openDetails(achievementUi)
            }
        }
    }

    inner class UnAchievedViewHolder(
        private val binding: AchievementItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(achievementUi: AchievementUi) {
            binding.achievementName.text = achievementUi.title
            binding.achievementImage.setImageResource(achievementUi.unAchievedImageRes)
            binding.root.setOnClickListener {
                clickListener.openDetails(achievementUi)
            }
        }
    }

    fun updateItems(newItems: List<AchievementUi>) {
        val diffCallback = AchievementDiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    private class AchievementDiffCallback(
        private val oldList: List<AchievementUi>,
        private val newList: List<AchievementUi>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].title == newList[newItemPosition].title
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    interface AchievementsClickListener {
        fun openDetails(achievementUi: AchievementUi)
    }
}