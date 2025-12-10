package com.example.sujudku

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getNextPrayer(): PrayerData {
    val list = PrayerRepository.getPrayerList()
    val now = Calendar.getInstance()

    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())

    for (p in list) {
        val c = Calendar.getInstance()
        c.time = sdf.parse(p.time)!!

        if (now.before(c)) {
            return p
        }
    }
    return list.first() // Setelah Isya kembali ke Subuh
}
