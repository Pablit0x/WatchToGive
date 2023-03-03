package com.ap.watchtogive.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ap.watchtogive.presentation.home.HomeScreen

@Composable
fun Navigation(){
    var navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "homepage",
    ) {
        composable(route = "homepage") {
            HomeScreen()
        }

//        composable(route = "vote") {
//            CharitySearchScreen()
//        }

    }
}