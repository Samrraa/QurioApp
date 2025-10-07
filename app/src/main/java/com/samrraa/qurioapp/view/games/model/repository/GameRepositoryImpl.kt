package com.samrraa.qurioapp.view.games.model.repository

import com.samrraa.qurioapp.view.games.model.GameCategory

class GameRepositoryImpl : IGameRepository {
    override suspend fun getGames(): List<GameCategory> {
        return GameCategory.entries.toList()
    }
}