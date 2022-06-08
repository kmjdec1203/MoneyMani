package com.example.moneymani.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R
import com.example.moneymani.adapter.MyAdapter

private var viewAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>? = null
private var viewManager: RecyclerView.LayoutManager? = null

class WordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_word, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview_word)

        recyclerView.apply {
            viewManager = LinearLayoutManager(activity, VERTICAL, false)
            viewAdapter = MyAdapter()
        }

        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        return view
    }
}