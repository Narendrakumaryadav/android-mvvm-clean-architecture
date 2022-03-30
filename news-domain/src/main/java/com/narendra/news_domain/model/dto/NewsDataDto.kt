package com.narendra.news_domain.model.dto

import androidx.annotation.Keep
import com.narendra.news_domain.model.News
import com.narendra.news_domain.model.NewsDetails

@Keep
data class NewsDataDto(
    val author: String?,
    val content: String?,
    val date: String?,
    val imageUrl: String?,
    val readMoreUrl: String?,
    val time: String?,
    val title: String,
    val url: String?
)

fun NewsDataDto.toNews(): News {
    return News(
        title = this.title,
        imageUrl = this.imageUrl
    )
}

fun NewsDataDto.toNewsDetails(): NewsDetails {
    return NewsDetails(
        author = this.author,
        content = this.content,
        date = this.date,
        imageUrl = this.imageUrl,
        readMoreUrl = this.readMoreUrl,
        title = this.title
    )
}