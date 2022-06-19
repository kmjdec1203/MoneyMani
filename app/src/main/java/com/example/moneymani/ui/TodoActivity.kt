package com.example.moneymani.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moneymani.R
import com.example.moneymani.databinding.ActivityTodoBinding
import com.example.moneymani.sqlite.TodoOpenHelper
import java.text.SimpleDateFormat
import java.util.*

class TodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding

    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN)

    companion object {
        private const val TODO = R.layout.activity_todo
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, TODO)
        binding.goMainIv.setOnClickListener {
            onBackPressed()
        }
        binding.addNoteIv.setOnClickListener {
            val title = binding.titleEt.text
            val content = binding.todoContentEt.text
            if (title == null || content == null) {
                Toast.makeText(this, "제목과 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()

            } else {
                val time = format.format(Date())
                val db = TodoOpenHelper(this).writableDatabase
                db.execSQL("insert into todolist values (\'$title\', \'$content\', \'$time\')")
                db.close()
                Toast.makeText(this, "메모가 등록되었습니다.", Toast.LENGTH_SHORT).show()
                onBackPressed()
            }
        }
    }


    override fun onBackPressed() {
        startActivity(Intent(this, MemoActivity::class.java))
        finish()
    }
}