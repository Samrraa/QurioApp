package com.samrraa.qurioapp.view.games

import com.samrraa.qurioapp.base.BaseView
import com.samrraa.qurioapp.view.games.model.Game

interface IGameView : BaseView {
    fun showGames(games: List<Game>)
}