package com.example.moneymani.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import android.view.MotionEvent
import com.example.moneymani.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        if (action == MotionEvent.ACTION_DOWN) {
            // 다음 화면으로 넘어갈 클래스 지정한다.
            val intent = Intent(applicationContext, StartActivity::class.java)
            startActivity(intent) // 다음 화면으로 넘어간다.
        }
        return super.onTouchEvent(event)
    }

    // 터치하면 화면 전환
}