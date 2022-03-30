package com.narendra.comman.queries

import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern


object QueryNormalizer {

    private val PATTERN_DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
    private val PATTERN_NON_LETTER_DIGIT_TO_SPACES = Pattern.compile("[^\\p{L}\\p{Nd}]")

    fun forSearch(searchTerm: CharSequence): String =
        Normalizer.normalize(searchTerm, Normalizer.Form.NFD)
            .run { PATTERN_DIACRITICS.matcher(this).replaceAll("") }
            .run { PATTERN_NON_LETTER_DIGIT_TO_SPACES.matcher(this).replaceAll(" ") }
            .lowercase(Locale.getDefault())

}