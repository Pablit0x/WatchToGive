package com.ap.watchtogive.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ap.watchtogive.presentation.home.componants.CurrentlyVotedForCard
import com.ap.watchtogive.presentation.home.componants.DisplayCurrentCount
import com.ap.watchtogive.presentation.home.componants.VoteWinnerCard
import com.ap.watchtogive.presentation.home.componants.WatchFAB
import com.ap.watchtogive.presentation.theme.BackgroundDark
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreen(
    navigate: () -> Unit,
    runAd: () -> Unit,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {

    homeScreenViewModel.setupListener()
    Log.d("lolipop","view.int: "+homeScreenViewModel.totalAdsWatched);
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = BackgroundDark,
        content = { paddingValues ->

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                //Counted Number.
                DisplayCurrentCount(
                    homeScreenViewModel.totalAdsWatched
                )

                //Recipient of the next payment
                VoteWinnerCard()

                //User's Current Vote
                CurrentlyVotedForCard(
                    navigate = {navigate()}
                )

                //FAB used to play Ads
                WatchFAB(clickEvent = {
                    //TODO SHOW ADD
                    runAd()
                })
            }
        }
    )
}


