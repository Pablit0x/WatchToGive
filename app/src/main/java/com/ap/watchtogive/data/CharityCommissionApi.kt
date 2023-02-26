package com.ap.watchtogive.data

import com.ap.watchtogive.data.dto.CharityDetailDto
import com.ap.watchtogive.data.dto.CharityDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CharityCommissionApi {
    @GET("api/searchCharityName/{charityName}")
    suspend fun getCharitiesByName(
        @Header("Ocp-Apim-Subscription-Key") apiKey: String,
        @Path("charityName") charityName : String
    ): List<CharityDto>

    @GET("api/allcharitydetails/{RegisteredNumber}/{suffix}")
    suspend fun getCharityByRegisteredNumber(
        @Header("Ocp-Apim-Subscription-Key") apiKey: String,
        @Path("registeredNumber") registeredNumber: Int,
        @Path("suffix") suffix : Int = 0
    ) : CharityDetailDto
}