package com.example.medicalinfoapp.ui.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medicalinfoapp.common.preference.IPreferenceDataSource
import com.example.medicalinfoapp.ui.common.types.RhType
import com.example.medicalinfoapp.ui.detail.input.IMainDetailViewModelInput
import com.example.medicalinfoapp.ui.detail.output.IMainDetailViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainDetailViewModel @Inject constructor(
    preferenceHelper: IPreferenceDataSource
) : ViewModel(), IMainDetailViewModelInput, IMainDetailViewModelOutput {
    private val preference = preferenceHelper

    val input: IMainDetailViewModelInput = this
    val output: IMainDetailViewModelOutput = this

    private val _editName: MutableLiveData<String> = MutableLiveData(preference.getUserName())
    override val editName: LiveData<String>
        get() = _editName

    private val _editBirth: MutableLiveData<String> = MutableLiveData(preference.getUserBirth())
    override val editBirth: LiveData<String>
        get() = _editBirth

    private val bloodType = preference.getUserBloodType()
    private val rhTypeValue =
        if(bloodType.isNotEmpty() && bloodType.contains(",")) {
            RhType.entries.firstOrNull() {
                it.type == bloodType.split(",")[0]
            } ?: RhType.RH_PLUS
        }else {
            RhType.RH_PLUS
        }

    private val bloodTypeValue = if(bloodType.isNotEmpty() && bloodType.contains(",")) {
        bloodType.split(",")[1]
    }else {
        "A"
    }


    private val _rhType: MutableLiveData<RhType> = MutableLiveData(rhTypeValue)
    override val rhType: LiveData<RhType>
        get() = _rhType

    private val _editBloodType: MutableLiveData<String> = MutableLiveData(bloodTypeValue)
    override val editBloodType: LiveData<String>
        get() = _editBloodType

    private val _expandState: MutableLiveData<Boolean> = MutableLiveData(false)
    override val expandState: LiveData<Boolean>
        get() = _expandState

    private val _editPhoneNumber: MutableLiveData<String> = MutableLiveData(preference.getUserPhoneNumber())
    override val editPhoneNumber: LiveData<String>
        get() = _editPhoneNumber

    private val _isShowEtcState: MutableLiveData<Boolean> = MutableLiveData(preference.getUserEtc().isNotEmpty())
    override val isShowEtcState: LiveData<Boolean>
        get() = _isShowEtcState

    private val _editEtc: MutableLiveData<String> = MutableLiveData(preference.getUserEtc())
    override val editEtc: LiveData<String>
        get() = _editEtc

    override fun changeName(value: String) {
        _editName.value = value
    }

    override fun changePhoneNumber(value: String) {
        _editPhoneNumber.value = value
    }

    override fun changeEtc(value: String) {
        _editEtc.value = value
    }

    override fun changeRhType(type: RhType) {
        if(_rhType.value != type) _rhType.value = type
    }

    override fun changeIsShowEtcState() {
        _isShowEtcState.value = !_isShowEtcState.value!!
    }

    override fun changeExpandedState(state: Boolean) {
        _expandState.value = state
    }

    override fun selectBloodType(type: String) {
        _editBloodType.value = type
        _expandState.value = false
    }

    override fun selectBirthDate(date: String) {
        _editBirth.value = date
    }

    override fun complete() {
        preference.setUserName(_editName.value.toString())
        preference.setUserBirth(_editBirth.value.toString())

        val resultBloodType = "${_rhType.value!!.type},${editBloodType.value.toString()}"
        preference.setUserBloodType(resultBloodType)

        preference.setUserPhoneNumber(_editPhoneNumber.value.toString())
        preference.setUserEtc(_editEtc.value.toString())
    }
}
