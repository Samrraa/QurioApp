package com.samrraa.qurioapp.model

data class CharacterUi(
    val characterImageRes: Int,
    val displayName: String,
    val age: Int,
    val power: String,
    val description: String,
    val price: String,
    val state: CharacterDisplayState,
)

enum class CharacterDisplayState {
    CHOSEN,
    OPENED,
    LOCKED
}
