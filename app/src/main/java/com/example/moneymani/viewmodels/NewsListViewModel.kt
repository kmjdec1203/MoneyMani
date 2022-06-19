package com.example.moneymani.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneymani.data.News
import com.example.moneymani.data.NewsRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion

@ExperimentalCoroutinesApi
class NewsListViewModel (
    private val repository: NewsRepository
): ViewModel() {

    private val _newsList = MutableLiveData<MutableList<News>>()
    val newsList: LiveData<MutableList<News>>
        get() = _newsList

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean>
        get() = _progress

    init {
        updateNewsData()
    }

    fun updateNewsData() {
        _progress.value = true
        _newsList.value = mutableListOf()
        viewModelScope.launch {
            val data = repository.getAllNews()
            data.onCompletion { _progress.value = false }
                .collect { _newsList.value = _newsList.value?.apply { add(it) } ?: mutableListOf(it) }
        }
    }
}