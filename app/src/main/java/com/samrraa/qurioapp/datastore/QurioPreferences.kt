package com.samrraa.qurioapp.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.samrraa.qurioapp.model.Achievement
import com.samrraa.qurioapp.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

const val PREFERENCES_NAME = "qurio_preferences"
private val Context.dataStore by preferencesDataStore(
    name = PREFERENCES_NAME
)


class QurioPreferences(private val context: Context) {

    suspend fun addAchievement(achievement: Achievement) {
        val listType = object : TypeToken<List<Achievement>>() {}.type
        val achievements =
            Gson().fromJson<List<Achievement>>(context.dataStore.data.map { it[ACHIEVEMENTS_KEY] }
                .first() ?: "", listType)
        context.dataStore.edit {
            it[CHARACTER_KEY] = Gson().toJson(achievements + achievement)
        }
    }

    suspend fun storeCharacter(character: Character) {
        context.dataStore.edit {
            it[CHARACTER_KEY] = Gson().toJson(character)
        }
    }

    suspend fun setOnboardingComplete(isComplete: Boolean) {
        context.dataStore.edit {
            it[ONBOARDING_COMPLETE_KEY] = isComplete
        }
    }

    suspend fun addLives(count: Int = 1) {
        val lives = context.dataStore.data.map { it[LIVES_KEY] }.first() ?: 0
        context.dataStore.edit {
            it[LIVES_KEY] = lives + count
        }
    }

    suspend fun addPoints(count: Int = 1) {
        val points = context.dataStore.data.map { it[POINTS_KEY] }.first() ?: 0
        context.dataStore.edit {
            it[POINTS_KEY] = points + count
        }
    }

    suspend fun addAwards(count: Int = 1) {
        val awards = context.dataStore.data.map { it[AWARDS_KEY] }.first() ?: 0
        context.dataStore.edit {
            it[AWARDS_KEY] = awards + count
        }
    }

    val achievementsFlow: Flow<List<Achievement>> = context.dataStore.data.map { preferences ->
        val characterJsonString = preferences[ACHIEVEMENTS_KEY]
        val listType = object : TypeToken<List<Achievement>>() {}.type
        Gson().fromJson(characterJsonString, listType)
    }
    val characterFlow: Flow<Character> = context.dataStore.data.map { preferences ->
        val characterJsonString = preferences[CHARACTER_KEY]
        if (characterJsonString != null) {
            Gson().fromJson(characterJsonString, Character::class.java)
        } else {
            Character.RIKA
        }
    }

    val onboardingCompleteFlow: Flow<Boolean> = context.dataStore.data.map {
        it[ONBOARDING_COMPLETE_KEY] ?: false
    }

    val livesFlow: Flow<Int> = context.dataStore.data.map { it[LIVES_KEY] ?: 0 }
    val pointsFlow: Flow<Int> = context.dataStore.data.map { it[POINTS_KEY] ?: 0 }
    val awardsFlow: Flow<Int> = context.dataStore.data.map { it[AWARDS_KEY] ?: 0 }

    private companion object {
        val ACHIEVEMENTS_KEY = stringPreferencesKey("ACHIEVEMENTS_KEY")
        val CHARACTER_KEY = stringPreferencesKey("CHARACTER_KEY")
        val ONBOARDING_COMPLETE_KEY = booleanPreferencesKey("ONBOARDING_COMPLETE_KEY")
        val LIVES_KEY = intPreferencesKey("LIVES_KEY")
        val POINTS_KEY = intPreferencesKey("POINTS_KEY")
        val AWARDS_KEY = intPreferencesKey("AWARDS_KEY")
    }
}