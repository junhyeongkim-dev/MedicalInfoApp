package com.example.medicalinfoapp.common.di

import com.example.medicalinfoapp.common.preference.IPreferenceDataSource
import com.example.medicalinfoapp.common.preference.PreferenceHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {

    @Singleton
    @Binds
    abstract fun getPreference(preferenceHelper: PreferenceHelper) : IPreferenceDataSource
}