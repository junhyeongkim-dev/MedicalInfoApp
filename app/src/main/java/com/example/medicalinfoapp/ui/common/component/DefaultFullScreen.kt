package com.example.medicalinfoapp.ui.common.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DefaultFullScreen(
    navController: NavController = rememberNavController(),
    titleName: String,
    menuName: String,
    isShowBackButton: Boolean,
    menuOnclick: () -> Unit,
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if(isShowBackButton) {
                            IconButton(
                                onClick = {
                                    navController.navigateUp()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "뒤로가기 버튼")
                            }
                        }

                        Text(
                            text = titleName,
                            style = LocalTextStyle.current.copy(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .width(0.dp)
                                .fillMaxHeight()
                                .weight(1f)
                        )
                        TextButton(
                            onClick = menuOnclick
                        ) {
                            Text(
                                text = menuName,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Yellow
                )
            )
        }
    ) {paddingValues ->
        content.invoke(paddingValues)
    }
}

@Preview
@Composable
fun ShowBackButtonDefaultFullScreenPreview() {
    DefaultFullScreen(
        titleName = "응급의료정보 입력",
        menuName = "완료",
        isShowBackButton = true,
        menuOnclick = {  }) {

    }
}

@Preview
@Composable
fun NoShowBackButtonDefaultFullScreenPreview() {
    DefaultFullScreen(
        titleName = "응급의료정보",
        menuName = "초기화",
        isShowBackButton = false,
        menuOnclick = {  }) {
    }
}