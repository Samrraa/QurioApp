package com.samrraa.qurioapp.view.games.model.repository

import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.view.games.model.Game
import com.samrraa.qurioapp.view.games.model.GameCategory

class GameRepositoryImpl : IGameRepository {
    override fun getGames(): List<Game> {
        return listOf(
            Game(GameCategory.MUSIC, R.drawable.music, R.color.secondary),
            Game(GameCategory.FOOD_AND_DRINK, R.drawable.food_and_drink, R.color.yellow),
            Game(GameCategory.GEOGRAPHY, R.drawable.geography, R.color.green),
            Game(
                GameCategory.GENERAL_KNOWLEDGE,
                R.drawable.general_knowledge,
                R.color.orange
            ),
            Game(GameCategory.FILM_AND_TV, R.drawable.televtion, R.color.secondary),
            Game(GameCategory.SOCIETY_AND_CULTURE, R.drawable.family, R.color.green)
        )

    }
}