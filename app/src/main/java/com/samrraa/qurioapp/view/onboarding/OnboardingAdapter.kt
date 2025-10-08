package com.samrraa.qurioapp.view.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.R

class OnboardingAdapter : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val layouts = listOf(
        R.layout.onboarding_first_page,
        R.layout.onboarding_second_page,
        R.layout.onboarding_third_page,
        R.layout.onboarding_forth_page
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        // Pages are static, no binding needed
        // If you need to bind data in the future, add it here
    }

    override fun getItemCount(): Int = layouts.size

    override fun getItemViewType(position: Int): Int = layouts[position]

    class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}