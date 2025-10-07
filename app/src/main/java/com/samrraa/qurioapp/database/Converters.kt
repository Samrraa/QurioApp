package com.samrraa.qurioapp.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.samrraa.qurioapp.model.GameResult

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromGame(gameResult: GameResult): String = gson.toJson(gameResult)

    @TypeConverter
    fun toGame(value: String): GameResult = gson.fromJson(value, GameResult::class.java)
}
