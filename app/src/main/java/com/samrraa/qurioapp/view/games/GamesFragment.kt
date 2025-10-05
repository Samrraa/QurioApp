package com.samrraa.qurioapp.view.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentGamesBinding
import com.samrraa.qurioapp.view.games.model.Game

class GamesFragment : BaseFragment<FragmentGamesBinding>() {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGamesBinding.inflate(inflater, container, false)

    private fun setupRecycler() {
        val games = listOf(
            Game("Music", R.drawable.music),
            Game("Food & Drink", R.drawable.ic_food_and_coffe),
            Game("Geography", R.drawable.green_image),
            Game("General knowledge", R.drawable.knowladge),
            Game("Television", R.drawable.tv),
            Game("Family", R.drawable.family)
        )

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = GameCardAdapter(games) {}

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }
}

