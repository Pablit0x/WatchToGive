package com.ap.watchtogive.common.utils

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    enum class ConnectivityStatus {
        AVAILABLE,
        UNAVAILABLE,
        LOSING,
        LOST,
        IDLE
    }

    fun observe() : Flow<ConnectivityStatus>
}