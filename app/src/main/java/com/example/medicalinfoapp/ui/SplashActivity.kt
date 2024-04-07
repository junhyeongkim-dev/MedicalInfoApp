package com.example.medicalinfoapp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.medicalinfoapp.ui.common.navigator.CommonNavHost
import com.example.medicalinfoapp.ui.theme.MedicalInfoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicalInfoAppTheme {
                CommonNavHost()
            }
        }
    }
}