package com.samrraa.qurioapp.view.games.model

data class Game(
    val title: GameCategory,
    val imageRes: Int,
    val borderColor: Int,

)

enum class GameCategory {
    GEOGRAPHY,
    SCIENCE,
    GENERAL_KNOWLEDGE,
    MUSIC,
    FILM_AND_TV,
    FOOD_AND_DRINK,
    SOCIETY_AND_CULTURE,
    SPORT_AND_LEISURE,
    HISTORY,
    ARTS_AND_LITERATURE
}