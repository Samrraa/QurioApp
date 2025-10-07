package com.samrraa.qurioapp.view.games.model.repository

import com.samrraa.qurioapp.view.games.model.Game

interface IGameRepository {
    fun getGames(): List<Game>
}