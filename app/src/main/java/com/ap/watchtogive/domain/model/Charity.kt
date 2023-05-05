package com.ap.watchtogive.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Charity(
    val name : String,
    val registrationNumber : Int,
    val isActive : Boolean
) : Parcelable
