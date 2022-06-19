package com.example.moneymani.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.moneymani.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

class StartActivity : AppCompatActivity() {

    private val wordFragment by lazy { WordFragment() }
    @ExperimentalCoroutinesApi
    private val newsFragment by lazy { NewsListFragment() }
    private val policyFragment by lazy { PolicyFragment() }
    private val memoActivity by lazy { MemoActivity() }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initNavigationBar()
    }

    @ExperimentalCoroutinesApi
    private fun initNavigationBar() {

        val bnv_main = findViewById<BottomNavigationView>(R.id.bnv_main)

        bnv_main.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_word -> {
                    pageTitle.text = "경제 단어 사전"
                    setFragment(wordFragment)
                }
                R.id.menu_news -> {
                    pageTitle.text = "경제 뉴스"
                    setFragment(newsFragment)
                }
                R.id.menu_policy -> {
                    pageTitle.text = "청년 정책"
                    setFragment(policyFragment)
                }
                R.id.menu_memo -> {
                    setActivity(memoActivity)
                }
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
    private fun setActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}