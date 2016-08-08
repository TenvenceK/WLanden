package com.tenvence.wlanden;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class WLan {
    /**
     * （静态公有方法）判断是否连接无线网
     *
     * @param context 上下文 (ActivityName).this
     * @return 是否连接无线网
     */
    private static boolean IsWiFi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) return true;
        else return false;
    }

    /**
     * （静态公有方法）返回WiFi名
     *
     * @param context 上下文 (ActivityName).this
     * @return WiFi的SSID
     */
    public static String GetWiFiName(Context context) {
        if (IsWiFi(context)) {
            WifiManager wifiManager = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            return wifiInfo.getSSID().replace("\"", "");
        } else return null;
    }

    /**
     * （静态公有方法）返回IP地址的字符串
     *
     * @param context 上下文 (ActivityName).this
     * @return IP地址
     */
    public static String GetIP(Context context) {
        if (IsWiFi(context)) {
            WifiManager wifiManager = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int IP = wifiInfo.getIpAddress();
            int IP_1 = (IP >> 24) & 0xFF;
            int IP_2 = (IP >> 16) & 0xFF;
            int IP_3 = (IP >> 8) & 0xFF;
            int IP_4 = IP & 0xFF;
            return IP_1 + "." + IP_2 + "." + IP_3 + "." + IP_4;
        } else return null;
    }

    /**
     * （静态公有方法）返回Mac地址的字符串
     *
     * @param context 上下文 (ActivityName).this
     * @return Mac地址
     */
    public static String GetMac(Context context) {
        if (IsWiFi(context)) {
            WifiManager wifiManager = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            return wifiInfo.getMacAddress();
        } else return null;
    }
}

