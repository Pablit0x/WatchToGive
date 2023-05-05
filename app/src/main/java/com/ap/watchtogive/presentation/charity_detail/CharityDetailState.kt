package com.ap.watchtogive.presentation.charity_detail

import com.ap.watchtogive.domain.model.CharityDetail

data class CharityDetailState(
    val isLoading : Boolean = false,
    val charityDetails : CharityDetail = CharityDetail(""),
    val error : String = ""
)
