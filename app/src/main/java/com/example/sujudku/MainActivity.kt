package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView // Import ini

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Contoh inisialisasi dan pengaturan data untuk daftar waktu sholat
        setupPrayerTimeItem(R.id.sholat_subuh, "Subuh", "04:30")
        setupPrayerTimeItem(R.id.sholat_dzuhur, "Dzuhur", "11:50")
        setupPrayerTimeItem(R.id.sholat_ashar, "Ashar", "15:10")
        setupPrayerTimeItem(R.id.sholat_maghrib, "Maghrib", "17:45")
        setupPrayerTimeItem(R.id.sholat_isya, "Isya", "19:00")

        // Panggil fungsi untuk mengatur Bottom Navigation
        setupBottomNavigation()
    }

    // Fungsi untuk mengatur Bottom Navigation Bar
    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Tandai item 'Home' sebagai yang sedang aktif saat ini
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    true // Sudah di Home
                }
                R.id.nav_dzikir -> {
                    // Pindah ke DzikirDoaActivity
                    startActivity(Intent(this, DzikirDoaActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    })
                    finish() // Tutup Activity ini
                    true
                }
                R.id.nav_saya -> {
                    // Pindah ke ProfileActivity
                    startActivity(Intent(this, ProfileActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    })
                    finish() // Tutup Activity ini
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi helper untuk mengisi data item waktu sholat dan menambahkan logika klik
    private fun setupPrayerTimeItem(includeId: Int, name: String, time: String) {
        val prayerLayout = findViewById<View>(includeId)
        val tvName = prayerLayout.findViewById<TextView>(R.id.tv_prayer_name)
        val tvTime = prayerLayout.findViewById<TextView>(R.id.tv_prayer_time)

        tvName.text = name
        tvTime.text = time

        // LOGIKA KLIK untuk pindah ke PrayerDetailActivity
        prayerLayout.setOnClickListener {
            val intent = Intent(this, PrayerDetailActivity::class.java).apply {
                putExtra("PRAYER_NAME", name)
                putExtra("PRAYER_TIME", time)
            }
            startActivity(intent)
        }
    }
}