package com.samrraa.qurioapp.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.samrraa.qurioapp.model.GameResult

class Converters {
    @TypeConverter
    fun fromGame(gameResult: GameResult): String = Gson().toJson(gameResult)

    @TypeConverter
    fun toGame(value: String): GameResult = Gson().fromJson(value, GameResult::class.java)
}
