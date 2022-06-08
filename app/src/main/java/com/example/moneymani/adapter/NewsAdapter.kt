package com.example.moneymani.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R

class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var titles = arrayOf("서울역 북부역세권 개발 본격화... 38층 복합단지 들어선다")
    var images = arrayOf("")

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemtitle: TextView = itemView.findViewById(R.id.item_news_title)
    }

    // 1. Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NewsAdapter.NewsViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_card_layout, parent, false)

        return NewsAdapter.NewsViewHolder(cardView)
    }

    // 2. Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.itemtitle.text = titles[position]

    }

    // 3. Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return 1
    }

}