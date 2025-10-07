package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.view.games.IGameView
import com.samrraa.qurioapp.view.games.model.repository.IGameRepository

class GamePresenter(
    private val gameRepository: IGameRepository,
    view: IGameView
) : BasePresenter<IGameView>(view) {

    init {
        getGames()
    }

    private fun getGames() {
        val games = gameRepository.getGames()
        view?.showGames(games)

    }

}