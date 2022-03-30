package com.narendra.comman.utils.extensions

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.style.URLSpan
import android.text.style.UnderlineSpan

fun Spannable.removeUnderline(): Spannable {
    val clone = SpannableStringBuilder.valueOf(this)

    for (span in clone.getSpans(0, clone.length, URLSpan::class.java).orEmpty()) {
        clone.setSpan(object : UnderlineSpan() {
            override fun updateDrawState(tp: TextPaint) {
                tp.isUnderlineText = false
            }
        }, clone.getSpanStart(span), clone.getSpanEnd(span), 0)
    }

    return clone
}
