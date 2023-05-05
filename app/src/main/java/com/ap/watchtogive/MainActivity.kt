package com.ap.watchtogive

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ap.watchtogive.common.Constants
import com.ap.watchtogive.common.utils.ConnectivityObserver
import com.ap.watchtogive.common.utils.ConnectivityObserverImpl
import com.ap.watchtogive.presentation.navigation.Navigation
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
    private lateinit var connectivityObserver: ConnectivityObserver
    var loadedAd: RewardedAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = ConnectivityObserverImpl(applicationContext)
        MobileAds.initialize(this@MainActivity) {}
        loadAd()
        setContent {
            val connectivityStatus by connectivityObserver.observe()
                .collectAsState(initial = ConnectivityObserver.ConnectivityStatus.IDLE)
            WatchToGiveTheme {
                if (connectivityStatus == ConnectivityObserver.ConnectivityStatus.IDLE) {
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                }
                else if (connectivityStatus != ConnectivityObserver.ConnectivityStatus.AVAILABLE) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.no_connection),
                            contentDescription = "No connection"
                        )
                        Text(
                            text = "Oh No!",
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(14.dp)
                        )
                        Text(
                            text = "Can't connect to network, check your connection and try again.",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp
                        )
                    }
                } else {
                    Navigation(
                        onNavigationAction = { showAd() }
                    )
                }
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
        if (loadedAd == null) {
            Toast.makeText(
                this@MainActivity,
                "No Ads Available! Please try again later",
                Toast.LENGTH_LONG
            ).show()
        }

        loadedAd?.show(this@MainActivity, OnUserEarnedRewardListener {
            val totalAdsWatched = Firebase.firestore
                .collection("total")
                .document("ads")
                .update("watched", FieldValue.increment(1))

            loadAd()
            Toast.makeText(this@MainActivity, "Thank You!", Toast.LENGTH_LONG).show()
        })
    }
}