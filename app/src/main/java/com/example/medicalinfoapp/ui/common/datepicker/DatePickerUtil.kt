package com.example.medicalinfoapp.ui.common.datepicker

import android.app.DatePickerDialog
import android.content.Context
import java.util.Calendar

class DatePickerUtil {

    companion object {

        // 날짜를 선택하는 함수
        fun showDatePickerDialog(context: Context, datePickerListener: (year: String, month: String, day: String) -> Unit) {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                context,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // 날짜 선택 후 실행될 코드

                    datePickerListener.invoke(selectedYear.toString(), selectedMonth.toString(), selectedDay.toString())
                }, year, month, day
            )
            datePickerDialog.show()
        }
    }
}
