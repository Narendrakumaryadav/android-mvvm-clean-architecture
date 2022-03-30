package com.narendra.newsapplication.news_list

import androidx.lifecycle.viewModelScope
import com.narendra.comman.base.BaseViewModel
import com.narendra.comman.model.Resource
import com.narendra.news_domain.use_case.NewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsListViewModel(private val newsUseCase: NewsUseCase) : BaseViewModel() {

    private val newsCategory: String = "all"
    private val _newsList = MutableStateFlow<NewsState>(NewsState())
    val newsList: StateFlow<NewsState> = _newsList

    init {
        getNews(newsCategory)
    }

    fun getNews(newsCategory: String) {
        viewModelScope.launch {
            newsUseCase.getNews(newsCategory).collect(){
                when (it) {
                    is Resource.Loading<*> -> {
                        _newsList.value = NewsState(isLoading = true)
                    }
                    is Resource.Success<*> -> {
                        _newsList.value = NewsState(data = it.data)
                    }
                    is Resource.Error<*> -> {
                        _newsList.value = NewsState(error = it.message ?: "")
                    }
                }
            }
        }
    }

}