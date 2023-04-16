package com.ap.watchtogive.presentation.charity_search

import com.ap.watchtogive.domain.model.Charity

data class CharitiesListState(
    val isLoading : Boolean = false,
    val charities : List<Charity> = emptyList(),
    val error : String = ""
)
