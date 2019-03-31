package com.app.newsapp

import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.app.newsapp.utils.isConnectedToInternet
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito


/**
 * @author Pranav Bhoraskar
 */

@RunWith(JUnit4::class)
class UtilsTest {

    @Test
    fun hasConnectionTest() {
        val context = Mockito.mock<Context>(Context::class.java)
        val connManager = Mockito.mock(ConnectivityManager::class.java)
        val networkInfo = Mockito.mock(NetworkInfo::class.java)
        val packageManager = Mockito.mock(PackageManager::class.java)

        Mockito.`when`(context.packageManager).thenReturn(packageManager)
        Mockito.`when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connManager)
        Mockito.`when`(connManager.activeNetworkInfo).thenReturn(networkInfo)
        Mockito.`when`(networkInfo.isAvailable).thenReturn(true)

        Mockito.`when`(networkInfo.isConnected).thenReturn(true)
        Assert.assertTrue(context.isConnectedToInternet())

        Mockito.`when`(networkInfo.isConnected).thenReturn(false)
        Assert.assertFalse(context.isConnectedToInternet())
    }

}