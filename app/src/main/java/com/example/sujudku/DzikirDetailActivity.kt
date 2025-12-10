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
                tvArab.text = "بِاسْمِكَ اللَّهُمَّ أَحْيَا وَبِاسْمِكَ أَمُوتُ"
                tvLatin.text = "Bismika Allahumma ahya wa bismika amuut"
                tvArti.text = "Dengan menyebut nama-Mu, ya Allah, aku hidup dan dengan menyebut nama-Mu aku mati."
            }


            "Ayat Kursi" -> {
                tvArab.text ="اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ۚ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ ۚ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ۗ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ ۚ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ ۖ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ ۚ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ ۖ وَلَا يَئُودُهُ حِفْظُهُمَا ۚ وَهُوَ الْعَلِيُّ الْعَظِيمُ"
                tvLatin.text = "Allahu la ilaha illa Huwal-Hayyul-Qayyum, la ta'khuzuhu sinatuw-wa la nawm. lahu ma fis-samawati wa ma fil-ard. man zallazi yashfa'u 'indahu illa bi'iznih. ya'lamu ma baina aidihim wa ma khalfahum, wa la yuhituna bishai'im-min 'ilmihi illa bima shaa'. wasi'a Kursiyyuhus-samawati wal-ard. wa la ya'uduhu hifzuhuma. wa Huwal-'Aliyyul-'Azim."
                tvArti.text = "Allah, tidak ada tuhan selain Dia. Yang Maha Hidup, Yang terus-menerus mengurus (makhluk-Nya), tidak pernah mengantuk dan tidak pernah tidur. Milik-Nya apa yang ada di langit dan apa yang ada di bumi. Tidak ada yang dapat memberi syafaat di sisi-Nya tanpa izin-Nya. Dia mengetahui apa yang ada di hadapan mereka dan apa yang ada di belakang mereka. Dan mereka tidak mengetahui sedikit pun dari ilmu-Nya kecuali apa yang Dia kehendaki. Kursi-Nya meliputi langit dan bumi. Dan Dia tidak merasa berat memelihara keduanya, dan Dia Maha Tinggi, Maha Besar."
            }

            "Doa Sebelum Makan" -> {
                tvArab.text = "اَللّٰهُمَّ بَارِكْ لَنَا فِيْمَا رَزَقْتَنَا وَقِنَا عَذَابَ النَّارُِ"
                tvLatin.text = "Allahumma barik lanaa fiimaa rozaqtanaa wa qinaa 'adzaabannaar"
                tvArti.text = "Ya Allah, berkahilah kami dengan rezeki yang telah Engkau berikan, dan jauhkanlah kami dari siksa api neraka."
            }
            "Doa Keluar Rumah" -> {
                tvArab.text = "بِسْمِ اللهِ تَوَكَّلْتُ عَلَى اللَّهِ لَاحَوْلَ وَلَا قُوَّةَ الا بالله"
                tvLatin.text = "Bismillaahi tawakkaltu 'alal laahi laa haula walaa quwwata illaa billaah"
                tvArti.text ="Dengan nama Allah aku bertawakal kepada Allah tiada daya untuk memperoleh manfaat dan tiada pula kuasa untuk menolak mudarat melainkan dengan pertolongan Allah"
            }
            "Sayyidul Istighfar" -> {
                tvArab.text = "اَللَّهُمَّ أَنْتَ رَبِّيْ لَا إِلَـهَ إِلَّا أَنْتَ، خَلَقْتَنِيْ وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوْذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوْءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوْءُ بِذَنْبِيْ فَغْفِرْ لِيْ فَإِنَّهُ لاَ يَغْفِرُ الذُّنُوْبَ إِلاَّ أَنْت"
                tvLatin.text = "Allahumma anta rabbī, lā ilāha illā anta, khalaqtanī wa anā ‘abduka, wa anā ‘alā ‘ahdika wa wa‘dika mā istaṭa‘tu, a‘ūdzu bika min syarri mā shana‘tu, abū’u laka bini‘matika ‘alayya, wa abū’u bidzanbī, faghfir lī, fa innahu lā yaghfiru dz-dzunūba illā anta."
                tvArti.text = "Ya Allah, Engkau adalah Tuhanku, tidak ada Tuhan selain Engkau. Engkau telah menciptakanku dan aku adalah hamba-Mu. Aku berusaha menjalankan janji dan ikatan kepada-Mu semampuku. Aku berlindung kepada-Mu dari keburukan yang aku lakukan. Aku mengakui segala nikmat yang Engkau berikan kepadaku, dan aku mengakui dosa-dosaku. Maka ampunilah aku, karena tidak ada yang dapat mengampuni dosa-dosa kecuali Engkau."
            }
            "Tasbih, Tahmid, Takbir" -> {
                tvArab.text = "سُبْحَانَ ٱللَّٰهِ, اَلْحَمْدُ لِلَّهِ, ٱللَّٰهُ أَكْبَرُ"
                tvLatin.text = "Subhanallah, Alhamdulillah, Allahuakbar"
                tvArti.text = "Maha Suci Allah, Segala Puji Bagi Allah, Allah Maha Besar"
            }


            else -> {
                tvArab.text = "Data Arab Tidak Ditemukan."
                tvLatin.text = "Data Latin Tidak Ditemukan."
                tvArti.text = "Data Arti Tidak Ditemukan."
            }

        }

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
//                R.id.nav_saya -> {
////                    {
////                        = Intent.FLAG_ACTIVITY_NO_ANIMATION
////                    })
//                    finish()
//                    true
//                }
                else -> false
            }
        }
    }
}
