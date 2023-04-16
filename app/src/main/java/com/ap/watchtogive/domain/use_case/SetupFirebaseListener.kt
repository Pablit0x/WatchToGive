package com.ap.watchtogive.domain.use_case

import com.ap.watchtogive.domain.repository.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow

class SetupFirebaseListener(
    private val repository: FirebaseRepository
) {

    suspend operator fun invoke(): Flow<Int> {
        return repository.setListener1()
    }
}