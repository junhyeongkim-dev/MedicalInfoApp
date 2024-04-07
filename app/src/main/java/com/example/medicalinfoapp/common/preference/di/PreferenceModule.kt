package com.example.medicalinfoapp.common.preference.di

import android.content.Context
import android.content.SharedPreferences
import com.example.medicalinfoapp.common.preference.IPreferenceDataSource
import com.example.medicalinfoapp.common.preference.PreferenceHelper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule @Inject constructor() {


    @Provides
    @Singleton
    @Named("PREFERENCES_NAME")
    fun provideSharedPreferencesName(): String {
        return "medical_info_app"
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(
        context: Context,
        @Named("PREFERENCES_NAME") preferencesName: String
    ): SharedPreferences {
        return context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun getPreference(preferenceHelper: PreferenceHelper) : IPreferenceDataSource = preferenceHelper
}