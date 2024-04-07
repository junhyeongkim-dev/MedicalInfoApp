package com.example.medicalinfoapp.ui.detail

import UserInfoRow
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.medicalinfoapp.ui.common.component.DefaultFullScreen
import com.example.medicalinfoapp.ui.common.datepicker.DatePickerUtil
import com.example.medicalinfoapp.ui.common.types.BloodType
import com.example.medicalinfoapp.ui.common.types.RhType
import com.example.medicalinfoapp.ui.detail.input.IMainDetailViewModelInput
import com.example.medicalinfoapp.ui.detail.output.IMainDetailViewModelOutput
import com.example.medicalinfoapp.ui.detail.viewmodel.MainDetailViewModel
import com.example.medicalinfoapp.ui.theme.MedicalInfoAppTheme

@Composable
fun MainDetailScreen(
    navController: NavController,
    mainDetailViewModel: MainDetailViewModel = hiltViewModel(),
) {
    DefaultFullScreen(
        navController = navController,
        titleName = "응급의료정보 입력",
        menuName = "완료",
        isShowBackButton = true,
        menuOnclick = {
            mainDetailViewModel.complete()
            navController.navigateUp()
        }
    ) {
        MainDetailColumn(
            topPadding = it.calculateTopPadding(),
            input = mainDetailViewModel.input,
            output = mainDetailViewModel.output
        )
    }
}

@Composable
fun MainDetailColumn(
    topPadding: Dp,
    input: IMainDetailViewModelInput,
    output: IMainDetailViewModelOutput
) {
    val context = LocalContext.current

    val editName by output.editName.observeAsState("")
    val editBirth by output.editBirth.observeAsState("")
    val rhType by output.rhType.observeAsState(RhType.RH_PLUS)
    val editBloodType by output.editBloodType.observeAsState("A")
    val editPhoneNumber by output.editPhoneNumber.observeAsState("")
    val editEtc by output.editEtc.observeAsState("")

    val expandState by output.expandState.observeAsState(false)
    val isShowEtcState by output.isShowEtcState.observeAsState(false)

    Column(
        modifier = Modifier.padding(top = topPadding)
    ) {
        UserInfoRow("이름") {
            TextField(
                modifier = Modifier
                    .width(200.dp),
                value = editName,
                onValueChange = {
                    input.changeName(it)
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
        }
        UserInfoRow("생년월일") {
            Text(
                modifier = Modifier.padding(end = 10.dp),
                text = editBirth,
                color = Color.Black,
                fontSize = 20.sp
            )

            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Calendar",
                modifier = Modifier
                    .size(28.dp)
                    .clickable(
                        onClick = {
                            datePickerIconClick(context, input)
                        },
                        role = Role.Button
                    ),
                tint = Color.Black
            )
        }
        UserInfoRow("혈액형") {
            RadioButton(
                selected = rhType == RhType.RH_PLUS,
                onClick = {
                    input.changeRhType(RhType.RH_PLUS)
                })

            Text(
                text = "RH+",
                color = Color.Black
            )

            RadioButton(
                selected = rhType == RhType.RH_MINUS,
                onClick = {
                    input.changeRhType(RhType.RH_MINUS)
                })

            Text(
                text = "RH-",
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                OutlinedIconButton(
                    modifier = Modifier
                        .width(80.dp),
                    onClick = {
                        input.changeExpandedState(true)
                    },
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(30)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = editBloodType,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "혈액형 선택 버튼",
                            tint = Color.Black
                        )
                    }
                }

                DropdownMenu(
                    expanded = expandState,
                    onDismissRequest = { // 사라질때
                        input.changeExpandedState(false)
                    }
                ) {
                    // 메뉴 안에 들어갈 값들

                    for (bloodType in BloodType.entries){
                        MenuItem(itemName = bloodType.name, input = input)
                    }
                }
            }
        }
        UserInfoRow("비상 연락처") {
            TextField(
                modifier = Modifier
                    .width(200.dp),
                value = editPhoneNumber,
                onValueChange = {
                    input.changePhoneNumber(it)
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                placeholder = {
                    Text(
                        text = "000-0000-0000",
                        fontSize = 20.sp
                    )
                },
                singleLine = true
            )
        }
        UserInfoRow("기타 주의사항") {
            Checkbox(
                checked = isShowEtcState,
                onCheckedChange = {
                    input.changeIsShowEtcState()
                }
            )

            Text(
                text = "주의사항을 노출",
                color = Color.Black
            )
        }

        if(isShowEtcState) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier
                    .width(0.dp)
                    .weight(1f)
                )

                TextField(
                    modifier = Modifier
                        .width(200.dp),
                    value = editEtc,
                    onValueChange = {
                        input.changeEtc(it)
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    singleLine = true
                )
            }
        }
    }
}

@Composable
fun MenuItem(
    itemName: String,
    input: IMainDetailViewModelInput
) {
    DropdownMenuItem(
        text = {
            Text(text = itemName)
        },
        onClick = {
            input.selectBloodType(itemName)
        }
    )
}

fun datePickerIconClick(
    context: Context,
    input: IMainDetailViewModelInput
) {
    DatePickerUtil.showDatePickerDialog(context) { year, month, day ->
        val resultDate = "${year}.${month.toInt().plus(1)}.${day}"

        input.selectBirthDate(resultDate)
    }
}

@Preview
@Composable
fun MainDetailScreenPreview() {
    MedicalInfoAppTheme {
//        MainDetailScreen()
    }
}