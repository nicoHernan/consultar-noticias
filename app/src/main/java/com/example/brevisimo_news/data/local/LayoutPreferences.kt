package com.example.brevisimo_news.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LayoutPreferences @Inject constructor(
    @ApplicationContext private val context: Context
){
    private val LAYOUT_KEY = booleanPreferencesKey("is_grid_layout")

    val isGridLayout: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[LAYOUT_KEY] ?: false
    }

    suspend fun setLayout(isGrid: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[LAYOUT_KEY] = isGrid
        }
    }
}