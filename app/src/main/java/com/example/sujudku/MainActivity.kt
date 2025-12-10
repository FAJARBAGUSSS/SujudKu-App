package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tombol Share
        val shareBtn = findViewById<ImageView>(R.id.btnShare)

        shareBtn.setOnClickListener {
            val text = """
        Waktu Sholat Hari Ini:
        Subuh   : 04:30
        Dzuhur  : 11:50
        Ashar   : 15:10
        Maghrib : 17:45
        Isya    : 19:00

        Dibagikan dari aplikasi SujudKu.
    """.trimIndent()

            shareContent(text)
        }


        // Contoh inisialisasi waktu sholat
        setupPrayerTimeItem(R.id.sholat_subuh, "Subuh", "04:30")
        setupPrayerTimeItem(R.id.sholat_dzuhur, "Dzuhur", "11:50")
        setupPrayerTimeItem(R.id.sholat_ashar, "Ashar", "15:10")
        setupPrayerTimeItem(R.id.sholat_maghrib, "Maghrib", "17:45")
        setupPrayerTimeItem(R.id.sholat_isya, "Isya", "19:00")

        // Bottom Navigation
        setupBottomNavigation()
    }

    // Fungsi untuk membagikan teks
    private fun shareContent(text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)

        startActivity(Intent.createChooser(shareIntent, "Bagikan via"))
    }

    // Bottom Navigation
    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_dzikir -> {
                    startActivity(Intent(this, DzikirDoaActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    })
                    finish()
                    true
                }
//                R.id.nav_saya -> {
//                    startActivity(Intent(this, ProfileActivity::class.java).apply {
//                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
//                    })
//                    finish()
//                    true
//                }
                else -> false
            }
        }
    }

    // Setup item waktu sholat
    private fun setupPrayerTimeItem(includeId: Int, name: String, time: String) {
        val prayerLayout = findViewById<View>(includeId)
        val tvName = prayerLayout.findViewById<TextView>(R.id.tv_prayer_name)
        val tvTime = prayerLayout.findViewById<TextView>(R.id.tv_prayer_time)

        tvName.text = name
        tvTime.text = time

        prayerLayout.setOnClickListener {
            val intent = Intent(this, PrayerDetailActivity::class.java).apply {
                putExtra("PRAYER_NAME", name)
                putExtra("PRAYER_TIME", time)
            }
            startActivity(intent)
        }
    }
}
