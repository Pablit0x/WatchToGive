package com.ap.watchtogive.domain.repository

import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    suspend fun setListener1() : Flow<Int>

}