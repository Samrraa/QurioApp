package com.samrraa.qurioapp.repository

import com.samrraa.qurioapp.model.Achievement
import com.samrraa.qurioapp.model.Character
import com.samrraa.qurioapp.model.GameCategory
import com.samrraa.qurioapp.model.GameResult
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    suspend fun getGameCategories(): List<GameCategory>
    fun getUserCharacter(): Flow<Character>
    fun getLastGames(): List<GameResult>
    fun getQuestions(): List<String>
    fun getGames(): List<GameCategory>
    fun getLives(): Flow<Int>
    fun getPoints(): Flow<Int>
    fun getAwards(): Flow<Int>
    fun getAllAchievements(): List<Achievement>
    suspend fun getMyAchievements(): List<Achievement>
    suspend fun addAchievement(achievement: Achievement)
}