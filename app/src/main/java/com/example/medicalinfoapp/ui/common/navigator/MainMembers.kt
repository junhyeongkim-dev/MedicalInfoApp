package com.example.medicalinfoapp.ui.common.navigator


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.medicalinfoapp.ui.detail.MainDetailScreen
import com.example.medicalinfoapp.ui.main.MainScreen


fun NavGraphBuilder.addMainScreen(navController: NavController) {
    composable(route = MainScreenMember.MAIN.name) {
        MainScreen(navController = navController)
    }
}

fun NavGraphBuilder.addMainDetailScreen(navController: NavController) {
    composable(route = MainScreenMember.MAIN_DETAIL.name) {
        MainDetailScreen(navController = navController)
    }
}