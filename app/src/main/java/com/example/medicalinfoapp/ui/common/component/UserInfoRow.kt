import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicalinfoapp.ui.theme.MedicalInfoAppTheme
import com.example.medicalinfoapp.ui.theme.Orange

@Composable
fun UserInfoRow(
    itemName: String,
    content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)
            .padding(
                start = 15.dp,
                end = 18.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(
            text = itemName,
            fontSize = 20.sp,
            color = Orange
        )
        Spacer(
            modifier = Modifier
                .width(0.dp)
                .weight(1f)
        )

        content.invoke()
    }
}

@Preview
@Composable
fun UserInfoRowPreview() {
    MedicalInfoAppTheme {
        UserInfoRow("이름") {
            Text(text = "홍길동")
        }
    }
}