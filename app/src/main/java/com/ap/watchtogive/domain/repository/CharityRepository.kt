package com.ap.watchtogive.domain.repository

import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto
import retrofit2.Response

interface CharityRepository {
    suspend fun getCharitiesByName(charityName : String) : List<CharityDto>
    suspend fun getCharityByRegisteredNumber(regNumber : Int) : CharityDetailDto
}