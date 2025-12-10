package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DzikirDoaActivity : AppCompatActivity() {

    // List dzikir awal (judul + arab)
    private val dzikirList = listOf(
        DzikirItem(R.id.item_tidur, "Doa Sebelum Tidur", "Bismika Allahumma ahya wa bismika annut"),
        DzikirItem(R.id.item_ayat_kursi, "Ayat Kursi", "Allahu la ilaha illa Huwa, Al-Hayyul-Qayyum"),
        DzikirItem(R.id.item_makan, "Doa Sebelum Makan", "Allahumma barik lana fi ma razaqtana"),
        DzikirItem(R.id.item_keluar_rumah, "Doa Keluar Rumah", "Bismillah, tawakkaltu 'alalallah"),
        DzikirItem(R.id.item_istighfar, "Sayyidul Istighfar", "Allahumma anta rabbi la ilaha illa anta"),
        DzikirItem(R.id.item_tasbih, "Tasbih, Tahmid, Takbir", "Subhanallah, Alhamdulillah, Allahuakbar")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzikir_doa)

        // Setup awal semua item
        dzikirList.forEach { item ->
            setupDzikirDoaItem(item.viewId, item.title, item.arab)
        }

        setupSearchFeature()
        setupBottomNavigation()
    }

    // ------------------------------------
    // 🔍 FITUR SEARCH
    // ------------------------------------
    private fun setupSearchFeature() {
        val searchView = findViewById<SearchView>(R.id.search_dzikir)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                val keyword = newText?.lowercase() ?: ""

                dzikirList.forEach { item ->
                    val layout = findViewById<View>(item.viewId)

                    // jika cocok → tampilkan
                    if (item.title.lowercase().contains(keyword)) {
                        layout.visibility = View.VISIBLE
                    } else {
                        layout.visibility = View.GONE
                    }
                }
                return true
            }
        })
    }

    // ------------------------------------
    // KLIK ITEM DZIKIR
    // ------------------------------------
    private fun setupDzikirDoaItem(includeId: Int, title: String, arabText: String) {
        val dzikirLayout = findViewById<View>(includeId)

        dzikirLayout.findViewById<TextView>(R.id.tv_dzikir_title).text = title
        dzikirLayout.findViewById<TextView>(R.id.tv_dzikir_arab).text = arabText

        dzikirLayout.setOnClickListener {
            Intent(this, DzikirDetailActivity::class.java).apply {
                putExtra("DZIKIR_NAME", title)
                startActivity(this)
            }
        }
    }

    // ------------------------------------
    // BOTTOM NAVIGATION
    // ------------------------------------
    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_dzikir

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_dzikir -> true

                R.id.nav_saya -> {
                    startActivity(Intent(this, ProfilActivity::class.java))
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}

// MODEL SIMPLE UNTUK DZIKIR
data class DzikirItem(
    val viewId: Int,
    val title: String,
    val arab: String
)
