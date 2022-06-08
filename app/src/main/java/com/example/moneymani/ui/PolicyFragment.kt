package com.example.moneymani.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R
import com.example.moneymani.adapter.PolicyAdapter

private var viewAdapter: RecyclerView.Adapter<PolicyAdapter.PolicyViewHolder>? = null
private var viewManager: RecyclerView.LayoutManager? = null

class PolicyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_policy, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview_policy)

        recyclerView.apply {
            viewManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            viewAdapter = PolicyAdapter()
        }

        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        return view
    }
}