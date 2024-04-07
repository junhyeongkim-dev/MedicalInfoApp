package com.example.medicalinfoapp.ui.detail.output

import androidx.lifecycle.LiveData
import com.example.medicalinfoapp.ui.common.types.RhType

interface IMainDetailViewModelOutput {

    val editName: LiveData<String>

    val editBirth: LiveData<String>

    val rhType: LiveData<RhType>
    val expandState: LiveData<Boolean>
    val editBloodType: LiveData<String>

    val editPhoneNumber: LiveData<String>

    val isShowEtcState: LiveData<Boolean>
    val editEtc: LiveData<String>
}