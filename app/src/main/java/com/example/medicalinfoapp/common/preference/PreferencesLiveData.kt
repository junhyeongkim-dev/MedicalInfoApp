package com.example.medicalinfoapp.common.preference

import android.content.SharedPreferences
import androidx.lifecycle.LiveData

class PreferencesLiveData(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defaultValue: String
) : LiveData<String>() {

    private val preferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { _, updatedKey ->
        if (updatedKey == key) {
            value = sharedPreferences.getString(key, defaultValue)
        }
    }

    override fun onActive() {
        super.onActive()
        value = sharedPreferences.getString(key, defaultValue)
        sharedPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener)
    }

    override fun onInactive() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(preferenceChangeListener)
        super.onInactive()
    }
}