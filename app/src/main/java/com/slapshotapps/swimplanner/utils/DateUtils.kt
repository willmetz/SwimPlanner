package com.slapshotapps.swimplanner.utils

import java.text.SimpleDateFormat
import java.util.*


val weekdayShortMonthDayFormat = SimpleDateFormat("EEE MM d", Locale.US)

fun dayPostfix(day: Int): String {

    when (day) {
        1, 21, 31 -> return "st"
        2, 22 -> return "nd"
        3, 23 -> return "rd"
        else -> return "th"
    }
}