package com.example.medicalinfoapp.ui.main

import UserInfoRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.medicalinfoapp.ui.common.component.DefaultFullScreen
import com.example.medicalinfoapp.ui.common.navigator.MainScreenMember
import com.example.medicalinfoapp.ui.main.output.IMainViewModelOutput
import com.example.medicalinfoapp.ui.main.viewmodel.MainViewModel
import com.example.medicalinfoapp.ui.theme.MedicalInfoAppTheme


@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    DefaultFullScreen(
        navController = navController,
        titleName = "응급의료정보",
        menuName = "초기화",
        isShowBackButton = false,
        menuOnclick = {
            mainViewModel.input.reset()
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                top = it.calculateTopPadding()
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MainColumn(mainViewModel.output)
            }

            Box(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                contentAlignment = Alignment.BottomCenter
            ) {
                FilledIconButton(
                    modifier = Modifier
                        .padding(
                            bottom = 200.dp
                        ),
                    onClick = {
                        navController.navigate(MainScreenMember.MAIN_DETAIL.name)
                    },
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.Blue
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "사용자 정보 추가 이미지 버튼",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun MainColumn(
    output: IMainViewModelOutput
) {
    val name by output.name.observeAsState("")
    val birth by output.birth.observeAsState("")
    val bloodType by output.bloodType.observeAsState("")
    val phoneNumber by output.phoneNumber.observeAsState("")
    val etc by output.etc.observeAsState("")

    Column {
        UserInfoRow("이름") {
            Text(
                text = name,
                color = Color.Black
            )
        }
        UserInfoRow("생년월일") {
            Text(
                text = birth,
                color = Color.Black
            )
        }
        UserInfoRow("혈액형") {
            Text(
                text = bloodType,
                color = Color.Black
            )
        }
        UserInfoRow("비상 연락처") {
            Text(
                text = phoneNumber,
                color = Color.Black
            )
        }
        UserInfoRow("기타 주의사항") {
            Text(
                text = etc,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MedicalInfoAppTheme {
//        MainScreen()
    }
}

