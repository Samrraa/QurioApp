package com.samrraa.qurioapp.view.achievement

import com.samrraa.qurioapp.base.BaseView
import com.samrraa.qurioapp.view.achievement.model.AchievementUi

interface IAchievementsView : BaseView {
    fun onGetAllAchievementsSuccess(achievements: List<AchievementUi>)
    fun onGetMyAchievementsSuccess(achievements: List<AchievementUi>)
}