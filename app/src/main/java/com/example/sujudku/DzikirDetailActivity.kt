package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.sujudku.utils.BottomNav   // <- pastikan ada ini

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

        // Set judul dan nama dzikir
        tvTitle.text = dzikirName
        tvName.text = dzikirName

        // Tombol kembali
        findViewById<View>(R.id.btn_back).setOnClickListener {
            startActivity(Intent(this, DzikirDoaActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            })
            finish()
        }

        // Mapping isi dzikir
        when (dzikirName) {
            "Doa Sebelum Tidur" -> {
                tvArab.text = "بِاسْمِكَ اللَّهُمَّ أَحْيَا وَبِاسْمِكَ أَمُوتُ"
                tvLatin.text = "Bismika Allahumma ahya wa bismika amuut"
                tvArti.text = "Dengan menyebut nama-Mu, ya Allah, aku hidup dan dengan menyebut nama-Mu aku mati."
            }

            "Ayat Kursi" -> {
                tvArab.text = "اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ..."
                tvLatin.text = "Allahu la ilaha illa Huwal-Hayyul-Qayyum..."
                tvArti.text = "Allah, tidak ada tuhan selain Dia..."
            }

            "Doa Sebelum Makan" -> {
                tvArab.text = "اَللّٰهُمَّ بَارِكْ لَنَا..."
                tvLatin.text = "Allahumma barik lanaa..."
                tvArti.text = "Ya Allah, berkahilah kami..."
            }

            "Doa Keluar Rumah" -> {
                tvArab.text = "بِسْمِ اللهِ تَوَكَّلْتُ..."
                tvLatin.text = "Bismillaahi tawakkaltu..."
                tvArti.text = "Dengan nama Allah aku bertawakal..."
            }

            "Sayyidul Istighfar" -> {
                tvArab.text = "اَللَّهُمَّ أَنْتَ رَبِّيْ..."
                tvLatin.text = "Allahumma anta rabbī..."
                tvArti.text = "Ya Allah, Engkau adalah Tuhanku..."
            }

            "Tasbih, Tahmid, Takbir" -> {
                tvArab.text = "سُبْحَانَ ٱللَّٰهِ..."
                tvLatin.text = "Subhanallah, Alhamdulillah..."
                tvArti.text = "Maha Suci Allah..."
            }

            else -> {
                tvArab.text = "Data Arab Tidak Ditemukan."
                tvLatin.text = "Data Latin Tidak Ditemukan."
                tvArti.text = "Data Arti Tidak Ditemukan."
            }
        }

        // Share
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
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        BottomNav.setup(this, bottomNav, R.id.nav_dzikir)
    }
}
