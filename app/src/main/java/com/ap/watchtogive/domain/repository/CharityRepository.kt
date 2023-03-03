package com.ap.watchtogive.domain.repository

import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto

interface CharityRepository {
    suspend fun getCharitiesByName(charityName : String) : List<CharityDto>
    suspend fun getCharityOverviewByRegisteredNumber(regNumber : Int) : CharityDetailDto
}