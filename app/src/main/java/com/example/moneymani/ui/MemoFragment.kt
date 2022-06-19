package com.example.moneymani.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R
import com.example.moneymani.adapter.MyAdapter
import com.example.moneymani.adapter.TodoAdapter
import com.example.moneymani.databinding.FragmentMemoBinding
import com.example.moneymani.dto.Todo
import com.example.moneymani.sqlite.TodoOpenHelper
import com.example.moneymani.viewmodels.MainModel
import java.util.*

class MemoFragment : Fragment() {

    private lateinit var viewAdapter: TodoAdapter
    private var viewManager: RecyclerView.LayoutManager? = null

    private lateinit var binding: FragmentMemoBinding
    private lateinit var todies: Vector<Todo>
    //private lateinit var adapter: TodoAdapter

    companion object {
        private const val MEMO = R.layout.fragment_memo
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        todies = Vector()

        val openHelper = TodoOpenHelper(requireContext())
        val db = openHelper.writableDatabase
        val cursor = db.rawQuery("select * from todolist", null)

        val count = cursor.count
        if(count >= 1) {
            while (cursor.moveToNext()) {
                val title = cursor.getString(0)
                val time = cursor.getString(2)
                todies.add(Todo(title, time))
            }
        }
        else {
            todies.add(Todo("등록된 메모가 없습니다.", ""))
        }

        cursor.close()
        //adapter = TodoAdapter(todies, requireContext())
        //binding.recyclerView.adapter = adapter

        binding.mainModel = MainModel(activity as AppCompatActivity, requireContext())
        binding.executePendingBindings()

        val view = inflater.inflate(R.layout.fragment_memo, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.mainToolbar)

        recyclerView.apply {
            viewManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            viewAdapter = TodoAdapter(todies, requireContext())
        }

        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        return view

    }

}