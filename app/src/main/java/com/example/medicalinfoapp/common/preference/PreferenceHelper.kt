package com.example.medicalinfoapp.common.preference

import android.content.Context
import android.content.SharedPreferences
import com.example.medicalinfoapp.common.preference.di.PreferenceModule
import javax.inject.Inject

class PreferenceHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IPreferenceDataSource {

    private fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    private fun getString(key: String) : String {
        return sharedPreferences.getString(key, "").toString()
    }

    private fun setInt(key: String, value: Int) {
        with(sharedPreferences.edit()) {
            putInt(key, value)
            apply()
        }
    }

    private fun getInt(key: String) : Int {
        return with(sharedPreferences) {
            getInt(key, 0)
        }
    }

    override fun setUserName(value: String) {
        setString(PreferenceKey.USER_NAME_KEY.key, value)
    }

    override fun getUserName(): String {
        return getString(PreferenceKey.USER_NAME_KEY.key)
    }

    override fun setUserBirth(value: String) {
        setString(PreferenceKey.USER_BIRTH_KEY.key, value)
    }

    override fun getUserBirth(): String {
        return getString(PreferenceKey.USER_BIRTH_KEY.key)
    }

    override fun setUserBloodType(value: String) {
        setString(PreferenceKey.USER_BLOOD_TYPE_KEY.key, value)
    }

    override fun getUserBloodType(): String {
        return getString(PreferenceKey.USER_BLOOD_TYPE_KEY.key.toString())
    }

    override fun setUserPhoneNumber(value: String) {
        setString(PreferenceKey.USER_PHONE_NUMBER_KEY.key, value)
    }

    override fun getUserPhoneNumber(): String {
        return getString(PreferenceKey.USER_PHONE_NUMBER_KEY.key)
    }

    override fun setUserEtc(value: String) {
        setString(PreferenceKey.USER_ETC_KEY.key, value)
    }

    override fun getUserEtc(): String {
        return getString(PreferenceKey.USER_ETC_KEY.key)
    }
}