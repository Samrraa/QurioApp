package com.samrraa.qurioapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.samrraa.qurioapp.model.GameResult

@Database(
    entities = [GameResult::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class QurioDatabase : RoomDatabase() {
    abstract fun getGameResultDao(): GameResultDao

    companion object {
        @Volatile
        private var INSTANCE: QurioDatabase? = null

        fun getDatabase(context: Context): QurioDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QurioDatabase::class.java,
                    "QurioDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

