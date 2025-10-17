package com.samrraa.qurioapp.view.lastgames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentLastGamesBinding
import com.samrraa.qurioapp.presenter.LastGamePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.lastgames.model.History
import javax.inject.Inject

class LastGamesFragment :
    BaseFragment<FragmentLastGamesBinding, ILastGamesView, LastGamePresenter>(), ILastGamesView {

    @Inject
    lateinit var repository: GameRepository

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLastGamesBinding.inflate(inflater, container, false)

    override fun initPresenter(): LastGamePresenter = LastGamePresenter(repository, this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.backArrow.setOnClickListener {
        }
    }

    override fun onGetLastGamesSuccess(games: List<History>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = LastGameAdapter(games)
            addItemDecoration(SpaceItemDecoration(requireContext(), 12))
        }
    }


}