package com.example.composeproject.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.composeproject.domain.manager.LocalUserManager
import com.example.composeproject.util.Constants
import com.example.composeproject.util.Constants.APP_ENTRY
import com.example.composeproject.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserImpl(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
      context.dataStore.edit { settings ->
         settings[ PreferenceKey.App_ENTRY] = true
      }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {preferences ->
            preferences[ PreferenceKey.App_ENTRY] ?: false

        }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferenceKey{
    val App_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)

}