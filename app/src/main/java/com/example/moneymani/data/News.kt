package com.example.moneymani.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News (
    val url: String,
    val title: String,
    val image: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}