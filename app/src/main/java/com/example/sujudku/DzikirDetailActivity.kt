package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class DzikirDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzikir_detail)

        val dzikirName = intent.getStringExtra("DZIKIR_NAME") ?: "Doa"

        val tvTitle = findViewById<TextView>(R.id.tv_detail_title)
        val tvName = findViewById<TextView>(R.id.tv_dzikir_name)
        val tvArab = findViewById<TextView>(R.id.tv_dzikir_arab)
        val tvLatin = findViewById<TextView>(R.id.tv_dzikir_latin)
        val tvArti = findViewById<TextView>(R.id.tv_dzikir_arti)
        val btnShare = findViewById<ImageView>(R.id.btn_share)

        // Set title & name
        tvTitle.text = dzikirName
        tvName.text = dzikirName

        // Tombol kembali
        findViewById<View>(R.id.btn_back).setOnClickListener {
            startActivity(Intent(this, DzikirDoaActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            })
            finish()
            true
        }

        // Mapping Dzikir → Arab, Latin, Arti
        when (dzikirName) {
            "Doa Sebelum Tidur" -> {
                tvArab.text = getString(R.string.doa_tidur_arab)
                tvLatin.text = getString(R.string.doa_tidur_latin)
                tvArti.text = getString(R.string.doa_tidur_arti)
            }

            "Ayat Kursi" -> {
                tvArab.text = getString(R.string.ayat_kursi_arab)
                tvLatin.text = getString(R.string.ayat_kursi_latin)
                tvArti.text = getString(R.string.ayat_kursi_arti)
            }

            else -> {
                tvArab.text = "Data Arab Tidak Ditemukan."
                tvLatin.text = "Data Latin Tidak Ditemukan."
                tvArti.text = "Data Arti Tidak Ditemukan."
            }
        }

        // 🔥 FITUR SHARE
        btnShare.setOnClickListener {
            val shareText = """
                🕌 *$dzikirName*
                
                ﷽
                ${tvArab.text}
                
                Latin:
                ${tvLatin.text}
                
                Artinya:
                ${tvArti.text}
                
                Dibagikan dari aplikasi Sujudku
            """.trimIndent()

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            startActivity(Intent.createChooser(shareIntent, "Bagikan Dzikir"))
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_dzikir

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    })
                    finish()
                    true
                }
                R.id.nav_dzikir -> true
                R.id.nav_saya -> {
                    startActivity(Intent(this, ProfileActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    })
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
