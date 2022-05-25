package com.example.moneymani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class StartActivity : AppCompatActivity() {

    private val wordFragment by lazy { WordFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initNavigationBar()
    }

    private fun initNavigationBar() {

        val bnv_main = findViewById<BottomNavigationView>(R.id.bnv_main)

        bnv_main.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_word -> setFragment(wordFragment)
            }
            return@setOnItemSelectedListener true
        }
        bnv_main.selectedItemId = R.id.menu_word
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fl_container, fragment
        ).commit()
    }
}