package com.ap.watchtogive.data.dto

import com.ap.watchtogive.domain.model.Charity

data class CharityDto(
    val charity_name: String,
    val date_of_registration: String,
    val date_of_removal: Any,
    val group_subsid_suffix: Int,
    val organisation_number: Int,
    val reg_charity_number: Int,
    val reg_status: String
)

fun CharityDto.toCharity () : Charity {
    return Charity(
        name = charity_name,
        registrationNumber = reg_charity_number,
        isActive = reg_status == "R"
    )
}


