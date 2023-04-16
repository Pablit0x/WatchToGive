package com.ap.watchtogive.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ap.watchtogive.presentation.home.HomeScreen
import com.ap.watchtogive.presentation.test.TestScreen


@Composable
fun Navigation(
    runAd: () -> Unit
){

    var navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "home",
    ) {

        composable(route = "home") {
            HomeScreen(
                navigate = { navController.navigate("test") },
                runAd = { runAd() }
            )
        }

        composable(route = "test") {
            TestScreen(
                returnToHome = {navController.navigate("home") }
            )
        }

    }
}