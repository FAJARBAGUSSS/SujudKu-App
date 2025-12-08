package com.example.sujudku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sujudku.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        buildFeatures {
            viewBinding true


        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtNama.text = "Sastro dumejo"
        binding.txtEmailHeader.text = "sastrowaluyo@gmail.com"

        binding.txtNamaValue.text = "Sastro Dumejo"
        binding.txtEmailValue.text = "sastrowaluyo@gmail.com"
        binding.txtLokasiValue.text = "Madiun, Indonesia"
    }
}
