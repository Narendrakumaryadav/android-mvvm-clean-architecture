package com.narendra.news_domain.model.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.narendra.news_domain.model.News
import com.narendra.news_domain.model.NewsDetails

@Keep
data class NewsDataDto(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("content")
    val content: String = "",
    @SerializedName("date")
    val date: String = "",
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("readMoreUrl")
    val readMoreUrl: String? = null,
    @SerializedName("time")
    val time: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = ""
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