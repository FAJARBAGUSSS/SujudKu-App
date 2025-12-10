package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PrayerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer_detail)

        val prayerName = intent.getStringExtra("PRAYER_NAME") ?: "Sholat"
        val prayerTime = intent.getStringExtra("PRAYER_TIME") ?: "00:00"

        val tvName = findViewById<TextView>(R.id.tv_detail_prayer_name)
        val tvTime = findViewById<TextView>(R.id.tv_detail_prayer_time)
        val tvDesc = findViewById<TextView>(R.id.tv_detail_deskripsi)
        val tvNiatArab = findViewById<TextView>(R.id.tv_detail_niat_arab)
        val tvNiatArti = findViewById<TextView>(R.id.tv_detail_niat_arti)
        val btnShare = findViewById<ImageView>(R.id.btn_share)

        tvName.text = prayerName
        tvTime.text = prayerTime

        // Set isi berdasarkan jenis sholat
        when (prayerName) {
            "Subuh" -> {
                tvDesc.text = getString(R.string.deskripsi_subuh)
                tvNiatArab.text = getString(R.string.niat_subuh_arab)
                tvNiatArti.text = getString(R.string.niat_subuh_arti)
            }

            // Tambah sholat lain di sini jika mau
        }

        // ➤ FITUR SHARE
        btnShare.setOnClickListener {
            val shareText = """
                🕌 *${prayerName}*
                🕒 Waktu: $prayerTime

                📖 Niat:
                ${tvNiatArab.text}

                Artinya:
                ${tvNiatArti.text}
            """.trimIndent()

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            startActivity(Intent.createChooser(shareIntent, "Bagikan Niat Sholat"))
        }
    }
}
