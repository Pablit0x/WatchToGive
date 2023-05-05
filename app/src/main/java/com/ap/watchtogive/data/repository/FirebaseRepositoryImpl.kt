package com.ap.watchtogive.data.repository

import com.ap.watchtogive.domain.repository.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


class FirebaseRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : FirebaseRepository {

    override suspend fun getTotalAdsWatched(): Flow<Long> = callbackFlow {
        val listenerRegistration = firestore.collection("total").document("ads")
            .addSnapshotListener { documentSnapshot, _ ->
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    val number = documentSnapshot.getLong("watched")
                    trySend(number ?: 0)
                }
            }
        awaitClose {
            listenerRegistration.remove()
        }
    }
}