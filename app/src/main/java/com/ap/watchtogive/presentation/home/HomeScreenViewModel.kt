package com.ap.watchtogive.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.watchtogive.domain.use_case.GetTotalAdsWatchedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTotalAdsWatchedUseCase: GetTotalAdsWatchedUseCase
) : ViewModel()
{
    var totalAdsWatched by mutableStateOf(0L)

   fun getTotalAdsWatched() = viewModelScope.launch {
      getTotalAdsWatchedUseCase().collect() { numberOfWatchedAds ->
          totalAdsWatched = numberOfWatchedAds
      }
   }
}