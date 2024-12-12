package com.example.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = RegisterFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()

            // Установка фрагмента нижней навигации
            val bottomNavFragment = BottomNavFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.bottomNavContainer, bottomNavFragment)
                .commit()

        }
    }
}