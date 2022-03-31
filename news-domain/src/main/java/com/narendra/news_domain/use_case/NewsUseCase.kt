package com.narendra.news_domain.use_case

import com.narendra.common.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import kotlinx.coroutines.flow.Flow

/**
 * Interface of NewsUseCase to expose to ui module
 */
interface NewsUseCase {
    /**
     * UseCase Method to fetch news from Data Layer
     */
    fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>>
}