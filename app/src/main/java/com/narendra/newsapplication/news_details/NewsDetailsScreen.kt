package com.narendra.newsapplication.news_details

import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Patterns
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.util.LinkifyCompat
import coil.compose.rememberAsyncImagePainter
import com.narendra.news_domain.model.NewsDetails

@Composable
fun NewsDetailsScreen(newsDetails: NewsDetails) {
    Card(
        // padding from our all sides.
        modifier = Modifier.padding(8.dp),
        // elevation for the card.
        elevation = 6.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(newsDetails.imageUrl),
                contentDescription = "image from news",
                modifier = Modifier.fillMaxWidth().height(250.dp).background(Color.Black),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = newsDetails.title,
                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                modifier = Modifier.padding(8.dp)
            )
            Text(text = newsDetails.date.orEmpty(), modifier = Modifier.padding(8.dp))
            Text(text = newsDetails.content.orEmpty(), modifier = Modifier.padding(8.dp))
            DefaultLinkifyText(
                Modifier.padding(8.dp),
                newsDetails.readMoreUrl.orEmpty()
            )
            Text(
                text = newsDetails.author.orEmpty(),
                modifier = Modifier.fillMaxSize().padding(8.dp),
                textAlign = TextAlign.End
                )
        }
    }
}

@Composable
fun DefaultLinkifyText(modifier: Modifier = Modifier, text: String?) {
    val context = LocalContext.current
    val customLinkifyTextView = remember {
        TextView(context)
    }
    AndroidView(modifier = modifier, factory = { customLinkifyTextView }) { textView ->
        textView.text = text ?: ""
        LinkifyCompat.addLinks(textView, Linkify.ALL)
        Linkify.addLinks(textView, Patterns.PHONE,"tel:",
            Linkify.sPhoneNumberMatchFilter, Linkify.sPhoneNumberTransformFilter)
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}