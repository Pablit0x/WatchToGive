package com.ap.watchtogive.data.dto

import com.ap.watchtogive.domain.model.Charity

data class TopCharityDto(
    val assets_long_term_investment: Double,
    val assets_other_assets: Double,
    val assets_own_use: Double,
    val assets_total_liabilities: Double,
    val charity_name: String,
    val defined_net_assets_pension: Double,
    val employees: Double,
    val exp_charitable_activities: Double,
    val exp_other: Double,
    val exp_raising_funds: Double,
    val exp_total: Double,
    val expenditure_growth: Double,
    val inc_charitable_activities: Double,
    val inc_donations_legacies: Double,
    val inc_investments: Double,
    val inc_other: Double,
    val inc_other_trading_activities: Double,
    val inc_total: Double,
    val income_growth: Double,
    val investment_gains_losses: Double,
    val last_modified_time: String,
    val order_no: Int,
    val organisation_number: Int,
    val reg_charity_number: Int,
    val trustees: Double,
    val type: String,
    val volunteers: Double
)

fun TopCharityDto.toCharity () : Charity {
    return Charity(
        name = charity_name,
        registrationNumber = reg_charity_number,
        isActive = true
    )
}