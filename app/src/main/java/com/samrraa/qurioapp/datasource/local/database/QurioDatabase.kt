package com.samrraa.qurioapp.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.samrraa.qurioapp.datasource.local.dao.Converters
import com.samrraa.qurioapp.datasource.local.dao.GameResultDao
import com.samrraa.qurioapp.model.GameResult

@Database(
    entities = [GameResult::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class QurioDatabase : RoomDatabase() {
    abstract fun getGameResultDao(): GameResultDao
}