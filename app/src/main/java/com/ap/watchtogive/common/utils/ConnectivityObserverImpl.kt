package com.ap.watchtogive.common.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class ConnectivityObserverImpl(
    private val context: Context
) : ConnectivityObserver {
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun observe(): Flow<ConnectivityObserver.ConnectivityStatus> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback(){
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch {send(ConnectivityObserver.ConnectivityStatus.AVAILABLE)}
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch {send(ConnectivityObserver.ConnectivityStatus.UNAVAILABLE)}
                }

                override fun onLosing(network: Network, maxMsToLive: Int) {
                    super.onLosing(network, maxMsToLive)
                    launch {send(ConnectivityObserver.ConnectivityStatus.LOSING)}

                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch {send(ConnectivityObserver.ConnectivityStatus.LOST)}

                }
            }

            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose{
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()
    }
}