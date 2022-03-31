package com.narendra.common.utils.extensions

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET

fun Context.isOnline(): Boolean {
    val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.allNetworks.any { network ->
        connectivityManager.getNetworkCapabilities(network)?.hasCapability(NET_CAPABILITY_INTERNET) == true
    }
}