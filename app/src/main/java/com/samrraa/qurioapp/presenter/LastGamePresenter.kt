package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.lastgames.ILastGamesView
import com.samrraa.qurioapp.view.mapper.lastgame.toHistoryUi
import javax.inject.Inject

class LastGamePresenter @Inject constructor(
    private val repository: GameRepository,
    view: ILastGamesView
) : BasePresenter<ILastGamesView>(view) {

    fun getLastGames() {
        tryToExecute(
            execute = { repository.getLastGames().toHistoryUi() },
            onSuccess = { game ->
                view?.onGetLastGamesSuccess(game)
            }
        )

    }
}
