package com.samrraa.qurioapp.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.samrraa.qurioapp.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val PREFERENCES_NAME = "qurio_preferences"
private val Context.dataStore by preferencesDataStore(
    name = PREFERENCES_NAME
)


class QurioPreferences(private val context: Context) {

    suspend fun storeCharacter(character: Character) {
        context.dataStore.edit {
            it[CHARACTER_KEY] = Gson().toJson(character)
        }
    }

    val characterFlow: Flow<Character> = context.dataStore.data
        .map { preferences ->
            val characterJsonString = preferences[CHARACTER_KEY]
            if (characterJsonString != null) {
                Gson().fromJson(characterJsonString, Character::class.java)
            } else {
                Character.RIKA
            }
        }


    private companion object {
        val CHARACTER_KEY = stringPreferencesKey("USER_NAME")
    }
}