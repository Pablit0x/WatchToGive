package com.ap.watchtogive.data

import com.ap.watchtogive.common.Constants
import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

/**
 * Interface to define HTTP operations that will need to be
 * performed. [GET,PUT,POST,DELETE]
 */
interface CharityCommissionApi {
    @GET("api/searchCharityName/{charityName}")
    suspend fun getCharitiesByName(
        @Header(Constants.API_HEADER) apiKey: String,
        @Path("charityName") charityName : String
    ): List<CharityDto>

    @GET("api/charityoverview/{registeredNumber}/{suffix}")
    suspend fun getCharityOverviewByRegisteredNumber(
        @Header(Constants.API_HEADER) apiKey: String,
        @Path("registeredNumber") registeredNumber: Int,
        @Path("suffix") suffix : Int = 0
    ) : CharityDetailDto

}