package com.example.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class authActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth2)

        if (savedInstanceState == null) {
            val fragment = AuthFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerAuth, fragment)
                .commit()

            val bottomNavFragment = BottomNavFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.bottomNavContainer, bottomNavFragment)
                .commit()
        }
    }
}