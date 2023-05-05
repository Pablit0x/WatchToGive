package com.ap.watchtogive.presentation.navigation

const val CHARITY_KEY = "charity_key"

sealed class Screen(val route: String){
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
    object Detail : Screen("detail_screen")
}

