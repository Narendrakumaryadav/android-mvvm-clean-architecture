package com.narendra.news_data.data.repository

import com.narendra.news_data.data.remote.NewsAPIService
import com.narendra.common.model.Resource
import com.narendra.news_domain.model.dto.NewsDataDto
import com.narendra.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
/**
 * Implementation of NewsRepository
 * @param newsAPI the object of news api service
 */
class NewsRepositoryImpl(private val newsAPI : NewsAPIService): NewsRepository {
    override fun getNews(newsCategory: String): Flow<Resource<List<NewsDataDto>?>> {
        return flow {
            try {
                emit(Resource.Loading())
                val newsListDto = newsAPI.getNews(newsCategory)
                emit(Resource.Success(data = newsListDto.data))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
            }
        }
    }
}