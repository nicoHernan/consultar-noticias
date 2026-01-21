package com.example.brevisimo_news.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "settings")

class LayoutPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val dataStore = context.dataStore
    companion object{
        val IS_GRID_LAYOUT = booleanPreferencesKey("")
        val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")
    }

    val isGridLayout: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_GRID_LAYOUT] ?: false
    }
    val isDarkMode: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_DARK_MODE] ?: false
    }

    suspend fun setLayout(isGrid: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_GRID_LAYOUT] = isGrid
        }
    }
    suspend fun setDarkMode(isDark: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = isDark
        }
    }
}