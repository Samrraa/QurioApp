package com.samrraa.qurioapp.util

import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

fun Int.toMinutesSecondsString(): String {
    val minutes = this / 60
    val seconds = this % 60
    val stringBuilder = StringBuilder()
    if (seconds != 0) stringBuilder.append("${seconds}sec")
    if (minutes != 0) stringBuilder.append("${minutes}m")
    return stringBuilder.toString()
}

@OptIn(ExperimentalTime::class)
fun Long.toFormattedDateString(): String {
    try {
        val instant = Instant.fromEpochMilliseconds(this)
        val timeZone = TimeZone.currentSystemDefault()
        val localDate = instant.toLocalDateTime(timeZone).date
        val day = localDate.day.toString().padStart(2, '0')
        val month = localDate.month.number.toString().padStart(2, '0')
        val year = localDate.year
        return "$day-$month-$year"
    } catch (_: Exception) {
        return "00-00-0000"
    }
}