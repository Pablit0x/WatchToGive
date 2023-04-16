package com.ap.watchtogive.presentation.charity_search

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.watchtogive.common.Resource
import com.ap.watchtogive.domain.model.CharityDetail
import com.ap.watchtogive.domain.use_case.GetCharitiesByNameUseCase
import com.ap.watchtogive.domain.use_case.GetCharityOverviewByRegistrationNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharitySearchViewModel @Inject constructor(
    private val getCharitiesByNameUseCase: GetCharitiesByNameUseCase,
    private val getCharityOverviewByRegistrationNumberUseCase: GetCharityOverviewByRegistrationNumberUseCase
) : ViewModel() {

    private val _listState = mutableStateOf(CharitiesListState())
    val listState : State<CharitiesListState> = _listState

    private val _detailState = mutableStateOf(CharityDetailState())
    val detailState : State<CharityDetailState> = _detailState

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    fun getCharityDetails(context: Context, charityRegNumber: Int ){
        getCharityOverviewByRegistrationNumberUseCase(regNumber = charityRegNumber).onEach { result ->
            when(result) {
                is Resource.Success ->{
                    if (result.data?.description != null) {
                        Toast.makeText(context, result.data.description, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(context, "Description is null", Toast.LENGTH_LONG).show()
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


    fun getCharities(charityName : String){
        getCharitiesByNameUseCase(charityName = charityName).onEach { result ->
            when(result) {
                is Resource.Success ->{
                    _listState.value = CharitiesListState(charities = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _listState.value = CharitiesListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    Log.d("different", "NO LADUJE SIE CZEKAJ!")
                    _listState.value = CharitiesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}