package com.samrraa.qurioapp.view.home

import com.samrraa.qurioapp.base.BaseView
import com.samrraa.qurioapp.model.Character
import com.samrraa.qurioapp.view.games.model.GameCategoryUi
import com.samrraa.qurioapp.view.lastgames.model.History
import kotlinx.coroutines.flow.Flow

interface IHomeView : BaseView {
    fun onGetCharacterSuccess(character: Character)
    fun onGetLastGamesSuccess(lastGames: List<History>)
    fun onGetGamesSuccess(games: List<GameCategoryUi>)
    fun onGetLivesSuccess(lives: Flow<Int>)
    fun onGetPointsSuccess(points: Flow<Int>)
    fun onGetAwardsSuccess(awards: Flow<Int>)
}