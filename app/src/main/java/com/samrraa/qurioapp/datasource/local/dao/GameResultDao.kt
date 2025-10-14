package com.samrraa.qurioapp.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samrraa.qurioapp.model.GameResult

@Dao
interface GameResultDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertGameResult(gameResult: GameResult)

    @Query("SELECT * FROM GAME_RESULTS ORDER BY date DESC")
    fun getAllGameResults(): List<GameResult>
}