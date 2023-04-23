package com.ap.watchtogive.data.repository

import com.ap.watchtogive.common.Constants
import com.ap.watchtogive.data.CharityCommissionApi
import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto
import com.ap.watchtogive.data.dto.TopCharityDto
import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.domain.model.CharityDetail
import com.ap.watchtogive.domain.repository.CharityRepository
import retrofit2.Response
import javax.inject.Inject

class CharityRepositoryImpl @Inject constructor(
    private val charityApi : CharityCommissionApi
) : CharityRepository{
    override suspend fun getCharitiesByName(charityName: String): List<CharityDto> {
        return charityApi.getCharitiesByName(charityName = charityName)
    }

    override suspend fun getCharityOverviewByRegisteredNumber(regNumber: Int): CharityDetailDto {
        return charityApi.getCharityOverviewByRegisteredNumber(registeredNumber = regNumber)
    }

    override suspend fun getTop10Charities(listType: String): List<TopCharityDto> {
        return charityApi.getTop10Charities()
    }

}