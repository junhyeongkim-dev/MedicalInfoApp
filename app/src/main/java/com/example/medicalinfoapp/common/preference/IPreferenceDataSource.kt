package com.example.medicalinfoapp.common.preference

interface IPreferenceDataSource {
    fun setUserName(value: String)
    fun getUserName() : String

    fun setUserBirth(value: String)
    fun getUserBirth() : String

    fun setUserBloodType(value: String)
    fun getUserBloodType() : String

    fun setUserPhoneNumber(value: String)
    fun getUserPhoneNumber() : String

    fun setUserEtc(value: String)
    fun getUserEtc() : String
}