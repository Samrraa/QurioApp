package com.samrraa.qurioapp.di

import com.samrraa.qurioapp.datasource.local.dao.GameResultDao
import com.samrraa.qurioapp.datastore.QurioPreferences
import com.samrraa.qurioapp.repository.GameRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGameRepository(
        gameResultDao: GameResultDao,
        preferences: QurioPreferences
    ) = GameRepositoryImpl(
        gameResultDao = gameResultDao,
        preferences = preferences
    )
}