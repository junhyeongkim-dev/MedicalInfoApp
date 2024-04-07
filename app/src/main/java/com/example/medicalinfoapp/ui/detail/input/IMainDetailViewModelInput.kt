package com.example.medicalinfoapp.ui.detail.input

import com.example.medicalinfoapp.ui.common.types.RhType

interface IMainDetailViewModelInput {
    fun changeName(value: String)
    fun changePhoneNumber(value: String)
    fun changeEtc(value: String)
    fun changeRhType(type: RhType)
    fun changeIsShowEtcState()
    fun changeExpandedState(state: Boolean)
    fun selectBloodType(type: String)
    fun selectBirthDate(date: String)
    fun complete()
}