package com.ap.watchtogive.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ap.watchtogive.presentation.home.componants.CurrentlyVotedForCard
import com.ap.watchtogive.presentation.home.componants.DisplayCurrentCount
import com.ap.watchtogive.presentation.home.componants.VoteWinnerCard
import com.ap.watchtogive.presentation.home.componants.WatchFAB
import com.ap.watchtogive.presentation.theme.BackgroundDark

@Composable
fun HomeScreen(
    navigate: () -> Unit,
    runAd: () -> Unit,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {

    homeScreenViewModel.getTotalAdsWatched()
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


