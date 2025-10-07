package com.samrraa.qurioapp.view.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentGamesBinding
import com.samrraa.qurioapp.presenter.GamePresenter
import com.samrraa.qurioapp.view.games.model.GameCategoryUi
import com.samrraa.qurioapp.view.games.model.repository.GameRepositoryImpl
import com.samrraa.qurioapp.view.games.model.repository.IGameRepository

class GamesFragment : BaseFragment<FragmentGamesBinding, IGameView, GamePresenter>(), IGameView {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGamesBinding.inflate(inflater, container, false)

    override fun initPresenter(): GamePresenter {
        val repository: IGameRepository = GameRepositoryImpl()
        return GamePresenter(repository, this)
    }


    override fun onGetGamesCategoriesSuccess(games: List<GameCategoryUi>) {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = GameCardAdapter(games) {}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getGames()
    }

}



