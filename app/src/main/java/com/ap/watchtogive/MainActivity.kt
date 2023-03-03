package com.ap.watchtogive

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ap.watchtogive.presentation.Navigation
import com.ap.watchtogive.presentation.theme.WatchToGiveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
             MobileAds.initialize(this@MainActivity) {}

            val fireStore = Firebase.firestore
            val totalAdsWatched = fireStore
                .collection("total")
                .document("ads")
                .addSnapshotListener { documentSnapshot, error ->
                    if(documentSnapshot != null && documentSnapshot.exists()){
                        var number = documentSnapshot.getLong("watched")!!.toInt()
                        mainViewModel.setNumberOfAdds(number)
                    }
                }
         */

        setContent {
            WatchToGiveTheme {
               Navigation()
            }
        }
    }
}