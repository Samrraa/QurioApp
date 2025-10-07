package com.samrraa.qurioapp.di

import android.content.Context
import com.samrraa.qurioapp.database.QurioDatabase
import com.samrraa.qurioapp.datastore.QurioPreferences
import com.samrraa.qurioapp.repository.GameRepositoryImpl

fun getGameRepository(context: Context) = GameRepositoryImpl(
    gameResultDao = QurioDatabase.getDatabase(context).getGameResultDao(),
    preferences = QurioPreferences(context)
)