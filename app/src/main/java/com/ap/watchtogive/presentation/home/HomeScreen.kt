package com.ap.watchtogive.presentation.home

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ap.watchtogive.presentation.home.componants.CurrentlyVotedForCard
import com.ap.watchtogive.presentation.home.componants.DisplayCurrentCount
import com.ap.watchtogive.presentation.home.componants.VoteWinnerCard
import com.ap.watchtogive.presentation.home.componants.WatchFAB
import com.ap.watchtogive.presentation.theme.BackgroundDark
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreen(){
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
                DisplayCurrentCount(0)

                //Recipient of the next payment
                VoteWinnerCard()

                //User's Current Vote
                CurrentlyVotedForCard()

                //FAB used to play Ads
                WatchFAB(clickEvent = {
                    //TODO SHOW ADD
                })
            }
        }
    )
}

//WatchAdd: ca-app-pub-4319651546258813/3576185255 <- real non-testID
fun showAd(activity: Activity){
    var adRequest = AdRequest.Builder().build()
    RewardedAd.load(
        activity,
        "ca-app-pub-3940256099942544/5224354917",
        adRequest,
        object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Toast.makeText(activity,"Error! Please try again later",Toast.LENGTH_LONG).show()
            }

            override fun onAdLoaded(ad: RewardedAd) {
                Log.d("ads", "[onAdLoaded]");
                ad.show(activity, OnUserEarnedRewardListener {
                    val totalAdsWatched = Firebase.firestore
                        .collection("total")
                        .document("ads")
                        .update("watched", FieldValue.increment(1))
                })
            }
        })

}

