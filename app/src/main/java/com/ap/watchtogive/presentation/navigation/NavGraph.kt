package com.ap.watchtogive.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.presentation.charity_detail.CharityDetailScreen
import com.ap.watchtogive.presentation.charity_search.CharitySearchScreen
import com.ap.watchtogive.presentation.home.HomeScreen


@Composable
fun Navigation(
    onNavigationAction: () -> Unit
){

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Screen.Home.route,
    ) {

        composable(route = Screen.Home.route) {
            HomeScreen(
                navigate = { navController.navigate(Screen.Search.route) },
                runAd = {onNavigationAction()}
            )
        }

        composable(route = Screen.Search.route) {
            CharitySearchScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route
        ){
            val selectedCharity = navController.previousBackStackEntry?.savedStateHandle?.get<Charity>(
                CHARITY_KEY)
            selectedCharity?.let { charity -> CharityDetailScreen(charity = charity) }
        }

    }
}