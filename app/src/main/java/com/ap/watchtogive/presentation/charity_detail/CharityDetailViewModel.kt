package com.ap.watchtogive.presentation.charity_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.watchtogive.common.Resource
import com.ap.watchtogive.domain.model.CharityDetail
import com.ap.watchtogive.domain.use_case.GetCharityOverviewByRegistrationNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharityDetailViewModel @Inject constructor(
    private val getCharityOverviewByRegistrationNumberUseCase: GetCharityOverviewByRegistrationNumberUseCase
) : ViewModel(){

    private val _detailState = mutableStateOf(CharityDetailState())
    val detailState : State<CharityDetailState> = _detailState

    fun getCharityDetails(charityRegNumber: Int ){
        getCharityOverviewByRegistrationNumberUseCase(regNumber = charityRegNumber).onEach { result ->
            when(result) {
                is Resource.Success ->{
                    if (result.data?.description != null) {
                        Log.d("ldadad", "boom")
                        _detailState.value = CharityDetailState(
                            charityDetails = CharityDetail(description = result.data.description)
                        )
                    }
                }
                is Resource.Error -> {
                    _detailState.value = CharityDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _detailState.value = CharityDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}