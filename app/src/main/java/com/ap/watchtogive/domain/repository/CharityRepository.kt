package com.ap.watchtogive.domain.repository

import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto
import com.ap.watchtogive.data.dto.TopCharityDto

interface CharityRepository {
    suspend fun getCharitiesByName(charityName : String) : List<CharityDto>
    suspend fun getCharityOverviewByRegisteredNumber(regNumber : Int) : CharityDetailDto
    suspend fun getTop10Charities(listType : String) : List<TopCharityDto>
}