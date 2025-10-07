package com.samrraa.qurioapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samrraa.qurioapp.database.DatabaseConstants.GAME_RESULTS_TABLE

@Entity(tableName = GAME_RESULTS_TABLE)
data class GameResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: GameCategory,
    val coinsCount: Int,
    val starsCount: Int,
    val durationInSeconds: Int,
    val date: Long = System.currentTimeMillis()
)