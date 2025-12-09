package com.example.sujudku

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PrayerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer_detail)

        // Ambil data yang dikirim dari MainActivity
        val prayerName = intent.getStringExtra("PRAYER_NAME") ?: "Sholat"
        val prayerTime = intent.getStringExtra("PRAYER_TIME") ?: "00:00"

        // Update tampilan berdasarkan data yang diterima
        findViewById<TextView>(R.id.tv_detail_prayer_name).text = prayerName
        findViewById<TextView>(R.id.tv_detail_prayer_time).text = prayerTime

        // Contoh Logika: Mengubah Niat & Deskripsi berdasarkan Nama Sholat
        if (prayerName == "Subuh") {
            findViewById<TextView>(R.id.tv_detail_deskripsi).text = getString(R.string.deskripsi_subuh)
            findViewById<TextView>(R.id.tv_detail_niat_arab).text = getString(R.string.niat_subuh_arab)
            findViewById<TextView>(R.id.tv_detail_niat_arti).text = getString(R.string.niat_subuh_arti)
        }
        // Anda bisa menambahkan 'else if (prayerName == "Dzuhur")' di sini untuk sholat lainnya
        // Untuk saat ini, kita hanya menampilkan data Subuh secara detail.
    }
}