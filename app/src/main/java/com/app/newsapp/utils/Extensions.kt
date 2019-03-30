package com.app.newsapp.utils

import android.content.Context
import android.net.ConnectivityManager
import java.text.SimpleDateFormat
import java.util.*

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

/**
 * Method converts given UTC time to given format
 *
 * @return String - Date and Time of the published news
 */
fun String.convertDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val currentdate = sdf.parse(this)
    val sdf2 = SimpleDateFormat("MMM dd,yyyy - HH:mm aaa", Locale.getDefault())
    return sdf2.format(currentdate)
}