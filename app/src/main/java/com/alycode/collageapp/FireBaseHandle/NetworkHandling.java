package com.alycode.collageapp.FireBaseHandle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.widget.Toast;

import com.alycode.collageapp.ui.fragment.MassageDialog;

public class NetworkHandling {
    public static NetworkHandling networkHandling;
    NetworkRequest networkRequest = new NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build();

    public static NetworkHandling getNetworkHandling() {
        if (networkHandling == null) {
            networkHandling = new NetworkHandling();
        }
        return networkHandling;
    }

    @SuppressLint("WrongConstant")
    public boolean checkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.
                getActiveNetworkInfo().isConnected() && connectivityManager.getActiveNetworkInfo().getState()== NetworkInfo.State.CONNECTED ) {

            return true;

        } else {
            Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
            MassageDialog.getMassageDialog().showErrorMassage();
            return false;

        }
    }

}
