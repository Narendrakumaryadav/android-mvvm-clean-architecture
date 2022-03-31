package com.narendra.news_domain.repository

import com.narendra.common.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import kotlinx.coroutines.flow.Flow
/**
 * Interface of News Repository to expose to other module
 */
interface NewsRepository {
     /**
      * Method to fetch the news from Repository
      * @return Flow of Resource with NewsDataDto list
      */
     fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>>
}