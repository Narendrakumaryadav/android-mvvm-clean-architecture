package com.narendra.news_domain

import com.narendra.news_domain.model.dto.NewsDataDto
import com.narendra.news_domain.model.dto.NewsListDto

fun getDummyNewsData() = listOf(
    NewsDataDto(
        author = "narendra",
        content = "fake news list repo",
        date = "29 march 2022, Tuesday",
        imageUrl = "dummy url",
        readMoreUrl = "dummy read more url",
        time = "10:04 AM",
        title = "title",
        url = "dummy url"
    )
)

fun getDummyNewsData1()  {
    var  newsDataDto : NewsDataDto? = null
    newsDataDto = NewsDataDto(
        author = "narendra",
        content = "fake news list repo",
        date = "29 march 2022, Tuesday",
        imageUrl = "dummy url",
        readMoreUrl = "dummy read more url",
        time = "10:04 AM",
        title = "title",
        url = "dummy url"
    )
}



fun getNews() = NewsListDto("all", getDummyNewsData(), true)