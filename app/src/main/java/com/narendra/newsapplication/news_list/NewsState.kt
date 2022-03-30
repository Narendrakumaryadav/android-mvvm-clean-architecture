package com.narendra.newsapplication.news_list

import com.narendra.news_domain.model.dto.NewsDataDto

data class NewsState(
    val isLoading: Boolean = false,
    val data: List<NewsDataDto>? = null,
    val error: String = ""
)