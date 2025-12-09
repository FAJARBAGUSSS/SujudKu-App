package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // --- Data Profil Simulasi ---
        val namaUser = "Sastro Dumejo"
        val emailUser = "sastrowaluyo@gmail.com"
        val lokasiUser = "Madiun, Indonesia"
        // -----------------------------

        // Menampilkan data di header
        findViewById<TextView>(R.id.tv_profile_name).text = namaUser
        findViewById<TextView>(R.id.tv_profile_email_top).text = emailUser

        // Mengisi data untuk item detail
        setupProfileItem(R.id.item_nama, "Nama", namaUser, R.drawable.ic_person)
        setupProfileItem(R.id.item_email, "Email", emailUser, R.drawable.ic_email) // Pastikan ic_email dibuat
        setupProfileItem(R.id.item_lokasi, "Lokasi", lokasiUser, R.drawable.ic_location) // Pastikan ic_location dibuat

        // Setup Bottom Navigation Bar
        setupBottomNavigation()
    }

    private fun setupProfileItem(includeId: Int, label: String, value: String, iconResId: Int) {
        val itemLayout = findViewById<View>(includeId)
        itemLayout.findViewById<TextView>(R.id.tv_profile_label).text = label
        itemLayout.findViewById<TextView>(R.id.tv_profile_value).text = value
        itemLayout.findViewById<ImageView>(R.id.iv_profile_icon).setImageResource(iconResId)
    }

    // Fungsi untuk mengelola Bottom Navigation Bar
    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_saya // Tandai 'Saya' sebagai yang aktif

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java).apply { flags = Intent.FLAG_ACTIVITY_NO_ANIMATION })
                    finish()
                    true
                }
                R.id.nav_dzikir -> {
                    startActivity(Intent(this, DzikirDoaActivity::class.java).apply { flags = Intent.FLAG_ACTIVITY_NO_ANIMATION })
                    finish()
                    true
                }
                R.id.nav_saya -> true // Sudah di ProfileActivity
                else -> false
            }
        }
    }
}