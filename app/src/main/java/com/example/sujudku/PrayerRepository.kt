package com.example.sujudku

object PrayerRepository {
    fun getPrayerList(): List<PrayerData> {
        return listOf(
            PrayerData("Subuh", "04:32", "Doa setelah sholat Subuh..."),
            PrayerData("Dzuhur", "11:52", "Doa setelah sholat Dzuhur..."),
            PrayerData("Ashar", "15:13", "Doa setelah sholat Ashar..."),
            PrayerData("Maghrib", "17:48", "Doa setelah sholat Maghrib..."),
            PrayerData("Isya", "18:59", "Doa setelah sholat Isya...")
        )
    }
}
