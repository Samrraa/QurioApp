package com.samrraa.qurioapp.view.lastgames

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.databinding.LastGameBinding
import com.samrraa.qurioapp.util.toFormattedDateString
import com.samrraa.qurioapp.util.toMinutesSecondsString
import com.samrraa.qurioapp.view.lastgames.model.History

class LastGameAdapter(
    private val items: List<History>,
) : RecyclerView.Adapter<LastGameAdapter.LastGameCardViewHolder>() {

    inner class LastGameCardViewHolder(private val binding: LastGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            binding.tvDate.text = history.date.toFormattedDateString()
            binding.tvTitle.text = binding.root.context.getString(history.subjectStringRes)
            binding.tvCoinsValue.text = history.coin.toString()
            binding.tvCoinsValue.setTextColor(
                ContextCompat.getColor(
                    binding.root.context,
                    if (history.coin < 0) R.color.red else R.color.on_primary
                )
            )
            binding.tvStarValue.text = history.star.toString()
            binding.tvTimeValue.text = history.time.toMinutesSecondsString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastGameCardViewHolder {
        val binding = LastGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LastGameCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LastGameCardViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size

}

class SpaceItemDecoration(
    private val context: Context,
    private val space: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = (space * context.resources.displayMetrics.density).toInt()
    }
}