package com.samrraa.qurioapp.repository

import com.samrraa.qurioapp.datasource.local.dao.GameResultDao
import com.samrraa.qurioapp.datastore.QurioPreferences
import com.samrraa.qurioapp.model.Character
import com.samrraa.qurioapp.model.GameCategory
import com.samrraa.qurioapp.model.GameResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gameResultDao: GameResultDao,
    private val preferences: QurioPreferences
) : GameRepository {
    override suspend fun getGameCategories(): List<GameCategory> = GameCategory.entries
    override fun getUserCharacter(): Flow<Character> = preferences.characterFlow
    override fun getLastGames(): List<GameResult> = gameResultDao.getAllGameResults()
    override fun getGames(): List<GameCategory> = GameCategory.entries
    override fun getLives(): Flow<Int> = preferences.livesFlow
    override fun getPoints(): Flow<Int> = preferences.pointsFlow
    override fun getAwards(): Flow<Int> = preferences.awardsFlow
    override fun getQuestions(): List<String> = listOf(
        "If animals could talk, which one would be the rudest?",
        "Would you rather fight one horse-sized duck or 100 duck-sized horses?",
        "If you were a vegetable, which one would you be?",
        "What’s the worst name you could give to a new planet?",
        "If pizza didn’t exist, what food would rule the world?",
        "If you could replace your nose with anything, what would you choose?",
        "If you were invisible for a day, what’s the silliest thing you would do?"
    )
}