package com.samrraa.qurioapp.view.games

import com.samrraa.qurioapp.base.BaseView
import com.samrraa.qurioapp.view.games.model.GameCategoryUi

interface IGameView : BaseView {
    fun onGetGamesCategoriesSuccess(games: List<GameCategoryUi>)
}