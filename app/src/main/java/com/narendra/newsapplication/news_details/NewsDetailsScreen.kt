package com.narendra.newsapplication.news_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.narendra.news_domain.model.NewsDetails

@Composable
fun NewsDetailsScreen(newsDetails: NewsDetails) {
    Card(
        // padding from our all sides.
        modifier = Modifier.padding(8.dp),
        // elevation for the card.
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(newsDetails.imageUrl),
                contentDescription = "image from news"
            )
            Text(text = newsDetails.title)
            Text(text = newsDetails.date.orEmpty())
            Text(text = newsDetails.content.orEmpty())
            Text(text = newsDetails.readMoreUrl.orEmpty())
        }
    }
}