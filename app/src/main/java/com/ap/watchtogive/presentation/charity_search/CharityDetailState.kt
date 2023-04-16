package com.ap.watchtogive.presentation.charity_search

import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.domain.model.CharityDetail

data class CharityDetailState(
    val isLoading : Boolean = false,
    val charityDetails : CharityDetail = CharityDetail(""),
    val error : String = ""
)
