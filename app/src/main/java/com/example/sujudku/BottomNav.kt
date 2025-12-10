package com.example.sujudku.utils

import android.app.Activity
import android.content.Intent
import com.example.sujudku.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.sujudku.R

object BottomNav {

    fun setup(activity: Activity, nav: BottomNavigationView, selectedId: Int) {

        nav.selectedItemId = selectedId

        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    if (selectedId != R.id.nav_home) {
                        activity.startActivity(
                            Intent(activity, MainActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                            }
                        )
                        activity.finish()
                    }
                    true
                }

                R.id.nav_dzikir -> true

                R.id.nav_saya -> {
                    if (selectedId != R.id.nav_saya) {
                        activity.startActivity(
                            Intent(activity, ProfilActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                            }
                        )
                        activity.finish()
                    }
                    true
                }

                else -> false
            }
        }
    }
}
