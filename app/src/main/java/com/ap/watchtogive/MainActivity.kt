package com.ap.watchtogive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ap.watchtogive.presentation.Navigation
import com.ap.watchtogive.presentation.theme.WatchToGiveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchToGiveTheme {
                Navigation()
            }
        }
    }
}