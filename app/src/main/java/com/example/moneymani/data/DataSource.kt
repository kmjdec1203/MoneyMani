package com.example.moneymani.data

import com.example.moneymani.data.News
import kotlinx.coroutines.flow.Flow


interface DataSource {
    fun getAllNews():Flow<News>
}