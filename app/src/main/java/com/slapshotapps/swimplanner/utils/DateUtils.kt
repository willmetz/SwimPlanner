package com.slapshotapps.swimplanner.utils

fun dayPostfix(day: Int): String {

    when (day) {
        1, 21, 31 -> return "st"
        2, 22 -> return "nd"
        3, 23 -> return "rd"
        else -> return "th"
    }
}