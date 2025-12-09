package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DzikirDoaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzikir_doa)

        // Setup data dan menambahkan listener klik
        setupDzikirDoaItem(R.id.item_tidur, "Doa Sebelum Tidur", "Bismika Allahumma ahya wa bismika annut")
        setupDzikirDoaItem(R.id.item_ayat_kursi, "Ayat Kursi", "Allahu la ilaha illa Huwa, Al-Hayyul-Qayyum")
        setupDzikirDoaItem(R.id.item_makan, "Doa Sebelum Makan", "Allahumma barik lana fi ma razaqtana")
        setupDzikirDoaItem(R.id.item_keluar_rumah, "Doa Keluar Rumah", "Bismillah, tawakkaltu \'alalallah, la haula")
        setupDzikirDoaItem(R.id.item_istighfar, "Sayyidul Istighfar", "Allahumma anta rabbi la ilaha illa anta")
        setupDzikirDoaItem(R.id.item_tasbih, "Tasbih, Tahmid, Takbir", "Subhanallah, Alhamdullilah, Allahuakbar")


        setupBottomNavigation()
    }
    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Tandai item 'Home' sebagai yang sedang aktif saat ini
        bottomNav.selectedItemId = R.id.nav_dzikir

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Pindah ke DzikirDoaActivity
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    })
                    finish() // Tutup Activity ini
                    true // Sudah di Home
                }
                R.id.nav_dzikir -> {

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
    private fun setupDzikirDoaItem(includeId: Int, title: String, arabText: String) {
        val dzikirLayout = findViewById<View>(includeId)
        val tvTitle = dzikirLayout.findViewById<TextView>(R.id.tv_dzikir_title)
        val tvArab = dzikirLayout.findViewById<TextView>(R.id.tv_dzikir_arab)

        tvTitle.text = title
        tvArab.text = arabText


        // --- LOGIKA KLIK DITAMBAHKAN DI SINI ---
        dzikirLayout.setOnClickListener {
            // Buat Intent untuk pindah ke DzikirDetailActivity
            val intent = Intent(this, DzikirDetailActivity::class.java).apply {
                // Kirim Nama Dzikir (Title) yang diklik sebagai parameter
                putExtra("DZIKIR_NAME", title)
            }
            startActivity(intent)
        }
    }
}