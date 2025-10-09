package com.samrraa.qurioapp.model

data class AchievementUi(
    val achievementImageRes: Int,
    val title: String,
    val isAchieved: Boolean,
    val description: String,
    val unAchievedImageRes: Int,
    val unAchievedDescription: String,
)
