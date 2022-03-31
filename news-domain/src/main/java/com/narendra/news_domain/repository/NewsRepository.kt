package com.narendra.news_domain.repository

import com.narendra.common.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
     fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>>
}