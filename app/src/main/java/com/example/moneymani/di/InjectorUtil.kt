package com.example.moneymani.di

import com.example.moneymani.data.NewsRepository
import com.example.moneymani.data.RemoteNewsData
import com.example.moneymani.data.RemoteNewsData.Companion.getInstance
import com.example.moneymani.viewmodels.NewsListViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * 수동 종속성 삽입
 * */

@ExperimentalCoroutinesApi
object InjectorUtil {

    private fun getNewsRepository(): NewsRepository {
        return NewsRepository.getInstance(
            RemoteNewsData.getInstance()
        )
    }

    fun provideNewsListViewModelFactory(): NewsListViewModelFactory {
        val repository =
            getNewsRepository()
        return NewsListViewModelFactory(repository)
    }
}