package com.example.medicalinfoapp.ui.main.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medicalinfoapp.common.preference.IPreferenceDataSource
import com.example.medicalinfoapp.common.preference.PreferenceKey
import com.example.medicalinfoapp.common.preference.PreferencesLiveData
import com.example.medicalinfoapp.ui.main.input.IMainViewModelInput
import com.example.medicalinfoapp.ui.main.output.IMainViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferenceHelper: IPreferenceDataSource,
    sharedPreferences: SharedPreferences
) : ViewModel(), IMainViewModelInput, IMainViewModelOutput {

    val input: IMainViewModelInput = this
    val output: IMainViewModelOutput = this

    override val name: LiveData<String> = PreferencesLiveData(sharedPreferences, PreferenceKey.USER_NAME_KEY.key, "")

    override val birth: LiveData<String> = PreferencesLiveData(sharedPreferences, PreferenceKey.USER_BIRTH_KEY.key, "")

    override val bloodType: LiveData<String> = PreferencesLiveData(sharedPreferences, PreferenceKey.USER_BLOOD_TYPE_KEY.key, "")

    override val phoneNumber: LiveData<String> = PreferencesLiveData(sharedPreferences, PreferenceKey.USER_PHONE_NUMBER_KEY.key, "")

    override val etc: LiveData<String> = PreferencesLiveData(sharedPreferences, PreferenceKey.USER_ETC_KEY.key, "")


    override fun reset() {
        preferenceHelper.setUserName("")
        preferenceHelper.setUserBirth("")
        preferenceHelper.setUserBloodType("")
        preferenceHelper.setUserPhoneNumber("")
        preferenceHelper.setUserEtc("")
    }
}