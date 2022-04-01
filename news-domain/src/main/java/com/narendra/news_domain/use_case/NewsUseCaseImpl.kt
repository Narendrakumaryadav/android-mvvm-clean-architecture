package com.narendra.news_domain.use_case

import com.narendra.common.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import com.narendra.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Implementation of News UseCase
 * @param newsRepository the news repository object
 */
internal class NewsUseCaseImpl(private val newsRepository : NewsRepository) : NewsUseCase {

    override fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>> {
        return newsRepository.getNews(newsCategory)
    }
}