package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.games.IGameView
import com.samrraa.qurioapp.view.mapper.games.toUi
import javax.inject.Inject

class GamePresenter @Inject constructor(
    private val gameRepository: GameRepository,
    view: IGameView
) : BasePresenter<IGameView>(view) {

    fun getGames() {
        tryToExecute(
            execute = { gameRepository.getGameCategories().toUi() },
            onSuccess = { game ->
                view?.onGetGamesCategoriesSuccess(game)
            }
        )


    }

}