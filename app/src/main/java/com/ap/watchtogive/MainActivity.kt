package com.ap.watchtogive

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.ap.watchtogive.common.Constants
import com.ap.watchtogive.presentation.Navigation
import com.ap.watchtogive.presentation.home.HomeScreenViewModel
import com.ap.watchtogive.presentation.theme.WatchToGiveTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    var loadedAd: RewardedAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this@MainActivity) {}

        loadAd()



        setContent {
            WatchToGiveTheme {
               Navigation(
                   runAd = { showAd() }
               )
            }
        }
    }

    //can we push this to another thread
    private fun loadAd() {
        var adRequest = AdRequest.Builder().build()
        RewardedAd.load(
            this,
            Constants.AD_MOB_KEY,
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    loadAd()
                }

                override fun onAdLoaded(ad: RewardedAd) {
                    loadedAd = ad
                }
            })
    }

    private fun showAd() {
        if (loadedAd == null){
            Toast.makeText(this@MainActivity,"No Ads Available! Please try again later", Toast.LENGTH_LONG).show()
        }

        loadedAd?.show(this@MainActivity, OnUserEarnedRewardListener {
            val totalAdsWatched = Firebase.firestore
                .collection("total")
                .document("ads")
                .update("watched", FieldValue.increment(1))

            loadAd()
        })
    }
}