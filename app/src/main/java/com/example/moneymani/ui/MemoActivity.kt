package com.example.moneymani.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneymani.R
import com.example.moneymani.adapter.TodoAdapter
import com.example.moneymani.databinding.ActivityMemoBinding
import com.example.moneymani.dto.Todo
import com.example.moneymani.sqlite.TodoOpenHelper
import com.example.moneymani.viewmodels.MainModel
import java.util.*

class MemoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoBinding
    private lateinit var todies : Vector<Todo>
    private lateinit var adapter : TodoAdapter



    companion object {
        private const val MEMO = R.layout.activity_memo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, MEMO)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        todies = Vector()
        val openHelper = TodoOpenHelper(this)
        val db = openHelper.writableDatabase
        val cursor = db.rawQuery("select * from todolist", null)

        val count = cursor.count
        if (count >= 1) {
            while (cursor.moveToNext()) {
                val title = cursor.getString(0)
                val time = cursor.getString(2)
                todies.add(Todo(title, time))
            }
        } else {
            todies.add(Todo("등록된 메모가 없습니다.", ""))
        }

        cursor.close()
        adapter = TodoAdapter(todies, this)
        binding.recyclerView.adapter = adapter

        binding.mainModel = MainModel(this, this)
        binding.executePendingBindings()
    }
}