package com.narendra.news_domain.use_case

import com.narendra.comman.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    suspend fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>>
}