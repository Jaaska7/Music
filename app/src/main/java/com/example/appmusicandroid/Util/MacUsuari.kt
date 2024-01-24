package com.example.appmusicandroid.Util

import android.content.Context
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build

class MacUsuari {
    companion object {
        fun obtenirMacAddress(context: Context): String {
            val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifiManager.isWifiEnabled = true
            val wifiInfo: WifiInfo? = wifiManager.connectionInfo

            return wifiInfo?.let {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    // A partir de Android 10 (API nivel 29), se requiere el permiso ACCESS_FINE_LOCATION
                    it.macAddress
                } else {
                    it.bssid
                }
            } ?: run {
                ""
            }
        }
    }
}
