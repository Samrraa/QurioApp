package com.samrraa.qurioapp.view.mapper.games

import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.view.games.model.Game
import com.samrraa.qurioapp.view.games.model.GameCategory

fun GameCategory.toGameUiModel(): Game {
    return when (this) {
        GameCategory.MUSIC -> Game(R.string.music, R.drawable.music, R.color.secondary)
        GameCategory.FOOD_AND_DRINK -> Game(
            R.string.food_drink,
            R.drawable.food_and_drink,
            R.color.yellow
        )

        GameCategory.GEOGRAPHY -> Game(R.string.geography, R.drawable.geography, R.color.green)
        GameCategory.SCIENCE -> Game(R.string.science, R.drawable.science, R.color.orange)
        GameCategory.FILM_AND_TV -> Game(R.string.film_tv, R.drawable.televtion, R.color.secondary)
        GameCategory.SOCIETY_AND_CULTURE -> Game(
            R.string.society_culture,
            R.drawable.family,
            R.color.green
        )

        GameCategory.GENERAL_KNOWLEDGE -> Game(
            R.string.general_knowledge,
            R.drawable.general_knowladge,
            R.color.orange
        )

        GameCategory.SPORT_AND_LEISURE -> Game(
            R.string.sport_leisure,
            R.drawable.sport_and_leisure,
            R.color.primary
        )

        GameCategory.HISTORY -> Game(R.string.history, R.drawable.history, R.color.orange)
        GameCategory.ARTS_AND_LITERATURE -> Game(
            R.string.arts_literature,
            R.drawable.arts_and_literature,
            R.color.primary
        )
    }
}

fun List<GameCategory>.toGameUiModel() = map { it.toGameUiModel() }