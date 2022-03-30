package com.narendra.news_domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsDetails (
    val author: String?,
    val content: String?,
    val date: String?,
    val imageUrl: String?,
    val readMoreUrl: String?,
    val title: String
) : Parcelable