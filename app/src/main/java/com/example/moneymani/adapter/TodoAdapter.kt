package com.example.moneymani.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.databinding.ItemTodolistBinding
import com.example.moneymani.dto.Todo
import java.util.*

class TodoAdapter(private var todos: Vector<Todo>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTodolistBinding.inflate(LayoutInflater.from(context),parent, false)
        return ItemHoder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemHoder
        val binding = itemHolder.binding
        val pos = (todos.size - 1) - position
        binding.todoTitleTv.text = todos[pos].title
        val time = "작성일 " + todos[pos].writeTime
        binding.noteDateTv.text = time

    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class ItemHoder(var binding: ItemTodolistBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}