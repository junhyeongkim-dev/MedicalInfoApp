package com.example.medicalinfoapp.ui.common.navigator

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun CommonNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreenGroup.MAIN_GROUP.name
    ) {

        //그룹으로 관리
        navigation(startDestination = MainScreenMember.MAIN.name, route = AppScreenGroup.MAIN_GROUP.name) {
            addMainScreen(navController)
            addMainDetailScreen(navController)
        }
    }
}
