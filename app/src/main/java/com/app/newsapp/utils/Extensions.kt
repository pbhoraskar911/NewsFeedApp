package com.app.newsapp.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author Pranav Bhoraskar
 */

/**
 *
 * Method checks the internet connectivity
 *
 * @return true - if internet is connected else false
 *
 */
fun Context.isConnectedToInternet(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetwork = cm.activeNetworkInfo

    return activeNetwork != null && activeNetwork.isConnected
}