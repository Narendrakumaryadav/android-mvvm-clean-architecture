package com.narendra.common.provider

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.narendra.common.utils.constants.SHARED_PREF

/**
 * Helper to provide SharedPreferences without leaking context and allow for unit testing
 */
class SharedPreferencesProvider(
    private val application: Application
) {

    fun getSharedPreferences(name: String = SHARED_PREF, mode: Int = Context.MODE_PRIVATE): SharedPreferences = application.getSharedPreferences(name, mode)
}