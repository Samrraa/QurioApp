package com.samrraa.qurioapp.di

import android.content.Context
import androidx.room.Room
import com.samrraa.qurioapp.datasource.local.dao.GameResultDao
import com.samrraa.qurioapp.datasource.local.database.QurioDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): QurioDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            QurioDatabase::class.java,
            "QurioDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideGameResultDao(database: QurioDatabase): GameResultDao {
        return database.getGameResultDao()
    }
}
