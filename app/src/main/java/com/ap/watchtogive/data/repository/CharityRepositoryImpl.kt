package com.ap.watchtogive.data.repository

import com.ap.watchtogive.common.Constants
import com.ap.watchtogive.data.CharityCommissionApi
import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto
import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.domain.model.CharityDetail
import com.ap.watchtogive.domain.repository.CharityRepository
import retrofit2.Response
import javax.inject.Inject

class CharityRepositoryImpl @Inject constructor(
    private val charityApi : CharityCommissionApi
) : CharityRepository{
    override suspend fun getCharitiesByName(charityName: String): List<CharityDto> {
        return charityApi.getCharitiesByName(apiKey = Constants.API_KEY, charityName = charityName)
    }

    override suspend fun getCharityByRegisteredNumber(regNumber: Int): CharityDetailDto {
        return charityApi.getCharityByRegisteredNumber(apiKey = Constants.API_KEY, registeredNumber = regNumber)
    }

}