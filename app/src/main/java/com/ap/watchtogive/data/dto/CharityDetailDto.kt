package com.ap.watchtogive.data.dto

import com.ap.watchtogive.domain.model.CharityDetail

data class CharityDetailDto(
    val CharityAoOCountryContinent: List<CharityAoOCountryContinent>,
    val CharityAoOLocalAuthority: List<Any>,
    val CharityAoORegion: List<CharityAoORegion>,
    val address_line_five: String,
    val address_line_four: Any,
    val address_line_one: String,
    val address_line_three: String,
    val address_line_two: String,
    val address_post_code: String,
    val charity_co_reg_number: String,
    val charity_name: String,
    val charity_type: String,
    val cif_cdf_ind: Any,
    val cio_dissolution_ind: Boolean,
    val cio_ind: Boolean,
    val constituency_name: List<ConstituencyName>,
    val date_of_interim_manager_appt: Any,
    val date_of_registration: String,
    val date_of_removal: Any,
    val email: String,
    val group_subsid_suffix: Int,
    val in_administration: Boolean,
    val insolvent: Boolean,
    val interim_manager_ind: Any,
    val last_modified_time: String,
    val latest_acc_fin_year_end_date: String,
    val latest_acc_fin_year_start_date: String,
    val latest_expenditure: Double,
    val latest_income: Double,
    val organisation_number: Int,
    val other_names: List<OtherName>,
    val phone: String,
    val prev_excepted_ind: Boolean,
    val reg_charity_number: Int,
    val reg_status: String,
    val removal_reason: Any,
    val reporting_status: String,
    val trustee_names: List<TrusteeName>,
    val web: String,
    val who_what_where: List<WhoWhatWhere>
)

fun CharityDetailDto.toCharityDetail() : CharityDetail{
    return CharityDetail(
        name = charity_name,
        type = charity_type
    )
}