package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class DzikirDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzikir_detail)

        // Ambil data yang dikirim dari DzikirDoaActivity
        val dzikirName = intent.getStringExtra("DZIKIR_NAME") ?: "Doa"

        // Mengatur judul dan tombol kembali
        findViewById<TextView>(R.id.tv_detail_title).text = dzikirName
        findViewById<TextView>(R.id.tv_dzikir_name).text = dzikirName
        findViewById<View>(R.id.btn_back).setOnClickListener {
            startActivity(Intent(this, DzikirDoaActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            })
            finish() // Tutup Activity ini
            true
        }

        // Contoh Logika: Mengisi Niat, Latin, dan Arti berdasarkan Nama Dzikir
        // Di sini Anda perlu memetakan (mapping) data lengkap dari setiap dzikir.

        when (dzikirName) {
            "Doa Sebelum Tidur" -> {
                findViewById<TextView>(R.id.tv_dzikir_arab).text = getString(R.string.doa_tidur_arab)
                findViewById<TextView>(R.id.tv_dzikir_latin).text = getString(R.string.doa_tidur_latin)
                findViewById<TextView>(R.id.tv_dzikir_arti).text = getString(R.string.doa_tidur_arti)
            }
            "Ayat Kursi" -> {
                findViewById<TextView>(R.id.tv_dzikir_arab).text = getString(R.string.ayat_kursi_arab)
                findViewById<TextView>(R.id.tv_dzikir_latin).text = getString(R.string.ayat_kursi_latin)
                findViewById<TextView>(R.id.tv_dzikir_arti).text = getString(R.string.ayat_kursi_arti)
            }
            // Tambahkan 'when' lain untuk dzikir lain seperti Doa Sebelum Makan, dll.
            else -> {
                // Default jika data tidak ditemukan
                findViewById<TextView>(R.id.tv_dzikir_arab).text = "Data Arab Tidak Ditemukan."
                findViewById<TextView>(R.id.tv_dzikir_latin).text = "Data Latin Tidak Ditemukan."
                findViewById<TextView>(R.id.tv_dzikir_arti).text = "Data Arti Tidak Ditemukan."
            }
        }
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
}