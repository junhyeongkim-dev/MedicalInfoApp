package com.example.medicalinfoapp.ui.common.component

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultContent(
    topPadding: Dp,
    isShowPlusButton: Boolean,
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(
            top = topPadding
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            content.invoke()
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

@Preview
@Composable
fun DefaultContentPreview() {
    DefaultContent(0.dp, true){

    }
}