package com.narendra.comman.utils.extensions

import com.narendra.comman.queries.QueryNormalizer

/**
 * Extension used to search query in string
 * @receiver String the text inside we want a match
 * @param query String the string to search
 * @return Boolean true if it's matching
 */
fun String.isMatchingWord(query: String): Boolean {
    val normalizedSource = QueryNormalizer.forSearch(this)
    return normalizedSource.startsWith(query) || (" $query") in normalizedSource
}