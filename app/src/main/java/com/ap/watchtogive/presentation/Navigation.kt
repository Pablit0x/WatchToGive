package com.ap.watchtogive.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ap.watchtogive.presentation.charity_search.CharitySearchScreen
import com.ap.watchtogive.presentation.home.HomeScreen
import com.ap.watchtogive.presentation.test.TestScreen


@Composable
fun Navigation(
    onNavigationAction: () -> Unit
){

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "HOME_SCREEN",
    ) {

        composable(route = "HOME_SCREEN") {
            HomeScreen(
                navigate = { navController.navigate("SEARCH_SCREEN") },
                runAd = {onNavigationAction()}
            )
        }

        composable(route = "SEARCH_SCREEN") {
            CharitySearchScreen(navController = navController)
        }

    }
}