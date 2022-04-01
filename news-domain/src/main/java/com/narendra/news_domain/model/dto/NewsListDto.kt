package com.narendra.news_domain.model.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class NewsListDto(
    @SerializedName("category")
    val category: String = "",
    @SerializedName("data")
    val `data`: List<NewsDataDto> = listOf(),
    @SerializedName("success")
    val success: Boolean = false
)