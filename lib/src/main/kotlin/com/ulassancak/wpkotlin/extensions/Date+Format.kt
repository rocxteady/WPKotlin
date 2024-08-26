package com.ulassancak.wpkotlin.extensions

import kotlinx.datetime.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

internal val LocalDateTime.javaVersion: java.time.LocalDateTime
    get() = java.time.LocalDateTime.of(
        year,
        monthNumber,
        dayOfMonth,
        hour,
        minute,
        second,
        nanosecond
    )

val java.time.LocalDateTime.formatted: String
    get() {
        val zonedDateTime = ZonedDateTime.of(this, ZoneId.of("UTC"))

        // Use DateTimeFormatter with the system's default locale
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.getDefault())

        return zonedDateTime.format(formatter)
    }

val LocalDateTime.formatted: String
    get() {
        val javaLocalDateTime = javaVersion
        val zonedDateTime = ZonedDateTime.of(javaLocalDateTime, ZoneId.of("UTC"))

        // Use DateTimeFormatter with the system's default locale
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.getDefault())

        return zonedDateTime.format(formatter)
    }