package com.samrraa.qurioapp.view.games.model.repository

import com.samrraa.qurioapp.view.games.model.GameCategory

interface IGameRepository {
    fun getGames(): List<GameCategory>
}