package com.samrraa.qurioapp.view.achievement.model

import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.model.Achievement

data class AchievementUi(
    val achievementImageRes: Int,
    val title: String,
    val description: String,
)

fun Achievement.toUi() = AchievementUi(
    achievementImageRes = this.toImageRes(),
    title = title,
    description = description
)

fun AchievementUi.toAchievement() = Achievement.entries.first { it.title == this.title }

private fun Achievement.toImageRes() = when (this) {
    Achievement.QUIZ_ROOKIE -> R.drawable.achievement_quiz_rookie
    Achievement.STREAK_STARTER -> R.drawable.achievement_streak_starter
    Achievement.LUCKY_GUESS -> R.drawable.achievement_lucky_guess
    Achievement.EXPLORER -> R.drawable.achievement_explorer
    Achievement.TRIVIA_CHAMP -> R.drawable.achievement_trivia_champ
    Achievement.COLLECTOR -> R.drawable.achievement_collector
    Achievement.QUICK_THINKER -> R.drawable.achievement_quick_thinker
}