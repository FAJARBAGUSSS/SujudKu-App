package com.example.sujudku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java
import kotlin.text.isNotEmpty

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Memanggil layout login

        val emailEditText: EditText = findViewById(R.id.et_email)
        val passwordEditText: EditText = findViewById(R.id.et_password)
        val loginButton: Button = findViewById(R.id.btn_masuk)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Simulasi Login Sederhana
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Pindah ke MainActivity (Home Page)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Tutup LoginActivity agar user tidak bisa kembali
            } else {
                Toast.makeText(this, "Mohon isi Email dan Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}