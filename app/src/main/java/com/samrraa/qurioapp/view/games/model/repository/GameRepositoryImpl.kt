package com.samrraa.qurioapp.view.games.model.repository

import com.samrraa.qurioapp.view.games.model.GameCategory

class GameRepositoryImpl : IGameRepository {
    override fun getGames(): List<GameCategory> {
        return listOf(
            GameCategory.MUSIC,
            GameCategory.FOOD_AND_DRINK,
            GameCategory.GEOGRAPHY,
            GameCategory.GENERAL_KNOWLEDGE,
            GameCategory.FILM_AND_TV,
            GameCategory.SOCIETY_AND_CULTURE,
            GameCategory.SCIENCE,
            GameCategory.SPORT_AND_LEISURE,
            GameCategory.HISTORY,
            GameCategory.ARTS_AND_LITERATURE
        )

    }
}