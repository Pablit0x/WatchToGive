package com.ap.watchtogive.data.repository

import com.ap.watchtogive.domain.repository.FirebaseRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class FirebaseRepositoryImpl () : FirebaseRepository{

    override suspend fun setListener1(): Flow<Int> =
        callbackFlow{
            val fireStore = Firebase.firestore
            val fireStoreCallback = fireStore
                .collection("total")
                .document("ads")
                .addSnapshotListener { documentSnapshot, _ ->
                    if(documentSnapshot != null && documentSnapshot.exists()){
                        var number = documentSnapshot.getLong("watched")!!.toInt()
                        trySend(number)
                    }
                }

            awaitClose {

            }
    }
}