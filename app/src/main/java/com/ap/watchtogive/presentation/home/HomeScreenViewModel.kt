package com.ap.watchtogive.presentation.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.watchtogive.domain.repository.FirebaseRepository
import com.ap.watchtogive.domain.use_case.SetupFirebaseListener
import com.ap.watchtogive.domain.use_case.UseCases
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCases : UseCases
) : ViewModel()
{

    var totalAdsWatched by mutableStateOf<Int>(0)

   fun setupListener() = viewModelScope.launch {
      useCases.setupFirebaseListener().collect() { R ->
          totalAdsWatched = R

          Log.d("FirebaseFlow", "ViewModel Response = $R");
      }
   }
}