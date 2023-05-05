package com.ap.watchtogive.presentation.charity_search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.watchtogive.common.Resource
import com.ap.watchtogive.domain.use_case.GetCharitiesByNameUseCase
import com.ap.watchtogive.domain.use_case.GetTop10CharitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharitySearchViewModel @Inject constructor(
    private val getCharitiesByNameUseCase: GetCharitiesByNameUseCase,
    private val getTop10CharitiesUseCase: GetTop10CharitiesUseCase
) : ViewModel() {

    private val _listState = mutableStateOf(CharitiesListState())
    val listState : State<CharitiesListState> = _listState

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

    init {
        getTop10Charities()
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
                    _listState.value = CharitiesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    fun getTop10Charities(){
        getTop10CharitiesUseCase().onEach { result ->
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
                    _listState.value = CharitiesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}