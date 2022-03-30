package com.narendra.news_domain.use_case

import com.narendra.comman.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import com.narendra.news_domain.repository.NewsRepository
import com.narendra.news_domain.use_case.NewsUseCase
import kotlinx.coroutines.flow.Flow

class NewsUseCaseImpl(private val newsRepository : NewsRepository) : NewsUseCase {

    override suspend fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>> {
        return newsRepository.getNews(newsCategory)
    }
}