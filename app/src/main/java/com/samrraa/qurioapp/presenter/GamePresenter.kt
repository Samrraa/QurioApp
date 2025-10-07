package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.view.games.IGameView
import com.samrraa.qurioapp.view.games.model.repository.IGameRepository
import com.samrraa.qurioapp.view.mapper.games.toUi

class GamePresenter(
    private val gameRepository: IGameRepository,
    view: IGameView
) : BasePresenter<IGameView>(view) {

    fun getGames() {
        tryToExecute(
            execute = { gameRepository.getGames().toUi() },
            onSuccess = { game ->
                view?.onShowGamesSuccess(game)
            }
        )


    }

}