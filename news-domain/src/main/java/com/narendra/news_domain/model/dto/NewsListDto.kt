package com.narendra.news_domain.model.dto

import androidx.annotation.Keep
import com.narendra.news_domain.model.dto.NewsDataDto

@Keep
data class NewsListDto(
    val category: String,
    val `data`: List<NewsDataDto>?,
    val success: Boolean
)