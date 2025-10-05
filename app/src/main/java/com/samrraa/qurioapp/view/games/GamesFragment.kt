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
            Game(getString(R.string.music), R.drawable.music, R.color.secondary),
            Game(getString(R.string.food_drink), R.drawable.ic_food_and_coffe, R.color.yellow),
            Game(getString(R.string.geography), R.drawable.green_image, R.color.green),
            Game(getString(R.string.general_knowledge), R.drawable.knowladge, R.color.orange),
            Game(getString(R.string.television), R.drawable.tv, R.color.secondary),
            Game(getString(R.string.family), R.drawable.family, R.color.green)
        )

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = GameCardAdapter(games) {}

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }
}

