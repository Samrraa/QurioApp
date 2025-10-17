package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.home.IHomeView
import com.samrraa.qurioapp.view.lastgames.model.History
import com.samrraa.qurioapp.view.mapper.games.toUi
import com.samrraa.qurioapp.view.mapper.lastgame.toHistoryUi
import kotlinx.coroutines.flow.first

class HomePresenter(view: IHomeView, private val repository: GameRepository) :
    BasePresenter<IHomeView>(view) {

    var lastGames = emptyList<History>()

    fun getCharacter() = tryToExecute(
        execute = { repository.getUserCharacter().first() },
        onSuccess = { view?.onGetCharacterSuccess(it) },
    )

    fun getLastGames() = tryToExecute(
        execute = repository::getLastGames,
        onSuccess = {
            lastGames = it.toHistoryUi()
            view?.onGetLastGamesSuccess(lastGames)
        },
    )

    fun getGames() = tryToExecute(
        execute = { repository.getGames().toUi() },
        onSuccess = { view?.onGetGamesSuccess(it) }
    )

    fun getLives() = tryToExecute(
        execute = { repository.getLives() },
        onSuccess = { view?.onGetLivesSuccess(it) }
    )

    fun getPoints() = tryToExecute(
        execute = { repository.getPoints() },
        onSuccess = { view?.onGetPointsSuccess(it) }
    )

    fun getAwards() = tryToExecute(
        execute = { repository.getAwards() },
        onSuccess = { view?.onGetAwardsSuccess(it) }
    )
}