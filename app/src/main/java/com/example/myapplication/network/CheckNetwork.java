package com.example.myapplication.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckNetwork {
    ConnectivityManager connectivityManager;
    NetworkInfo wifiInfo, mobileInfo, ethernetInfo;
    private static final int TYPE_ETHERNET = 7;

    /**
     * this method is used to check the network connection is available or not.
     *
     * if network(wifi or mobile or ethernet) connection available,it returns true
     * otherwise it returns false.
     *
     */
    public Boolean checkNow(Context con) {
        try {
            connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            ethernetInfo = connectivityManager.getNetworkInfo(TYPE_ETHERNET);

            if (wifiInfo.isConnected() || mobileInfo.isConnected() || ethernetInfo.isConnected()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }
}
