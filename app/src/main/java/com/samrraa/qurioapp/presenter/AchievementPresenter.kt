package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.achievement.IAchievementsView
import com.samrraa.qurioapp.view.achievement.model.AchievementUi
import com.samrraa.qurioapp.view.achievement.model.toAchievement
import com.samrraa.qurioapp.view.achievement.model.toUi

class AchievementPresenter(view: IAchievementsView, private val repository: GameRepository) :
    BasePresenter<IAchievementsView>(view) {

    fun getAllAchievements() = tryToExecute(
        execute = repository::getAllAchievements,
        onSuccess = { view?.onGetAllAchievementsSuccess(it.map { achievement -> achievement.toUi() }) },
    )

    fun getMyAchievements() = tryToExecute(
        execute = repository::getMyAchievements,
        onSuccess = { view?.onGetMyAchievementsSuccess(it.map { achievement -> achievement.toUi() }) },
    )

    fun addAchievement(achievement: AchievementUi) = tryToExecute(
        execute = { repository.addAchievement(achievement.toAchievement()) }
    )
}