package com.ap.watchtogive.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel()
{
    val fireStore = Firebase.firestore
    val fireStoreCallback = fireStore
        .collection("total")
        .document("ads")
        .addSnapshotListener { documentSnapshot, error ->
            if(documentSnapshot != null && documentSnapshot.exists()){
                var number = documentSnapshot.getLong("watched")!!.toInt()
                totalAdsWatched = number
            }
        }

    var totalAdsWatched by mutableStateOf<Int>(0)
}