package com.example.medicalinfoapp.ui.main.output

import androidx.lifecycle.LiveData

interface IMainViewModelOutput {
    val name: LiveData<String>
    val birth: LiveData<String>
    val bloodType: LiveData<String>
    val phoneNumber: LiveData<String>
    val etc: LiveData<String>
}