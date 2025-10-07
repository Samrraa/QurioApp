package com.samrraa.qurioapp.view.mapper.games

import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.view.games.model.GameCategory
import com.samrraa.qurioapp.view.games.model.GameCategoryUi

fun GameCategory.toUi(): GameCategoryUi {
    return when (this) {
        GameCategory.MUSIC -> GameCategoryUi(R.string.music, R.drawable.music, R.color.secondary)
        GameCategory.FOOD_AND_DRINK -> GameCategoryUi(
            R.string.food_drink,
            R.drawable.food_and_drink,
            R.color.yellow
        )

        GameCategory.GEOGRAPHY -> GameCategoryUi(
            R.string.geography,
            R.drawable.geography,
            R.color.green
        )

        GameCategory.SCIENCE -> GameCategoryUi(R.string.science, R.drawable.science, R.color.orange)
        GameCategory.FILM_AND_TV -> GameCategoryUi(
            R.string.film_tv,
            R.drawable.televtion,
            R.color.secondary
        )

        GameCategory.SOCIETY_AND_CULTURE -> GameCategoryUi(
            R.string.society_culture,
            R.drawable.family,
            R.color.green
        )

        GameCategory.GENERAL_KNOWLEDGE -> GameCategoryUi(
            R.string.general_knowledge,
            R.drawable.general_knowladge,
            R.color.orange
        )

        GameCategory.SPORT_AND_LEISURE -> GameCategoryUi(
            R.string.sport_leisure,
            R.drawable.sport_and_leisure,
            R.color.primary
        )

        GameCategory.HISTORY -> GameCategoryUi(R.string.history, R.drawable.history, R.color.orange)
        GameCategory.ARTS_AND_LITERATURE -> GameCategoryUi(
            R.string.arts_literature,
            R.drawable.arts_and_literature,
            R.color.primary
        )
    }
}

fun List<GameCategory>.toUi() = map { it.toUi() }