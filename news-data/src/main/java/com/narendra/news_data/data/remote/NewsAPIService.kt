package com.narendra.news_data.data.remote

import com.narendra.news_domain.model.dto.NewsListDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API Service
 */
interface NewsAPIService {

    @GET("news")
    suspend fun getNews(
        @Query("category") categoryName: String
    ): NewsListDto

}