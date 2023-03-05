package com.ap.watchtogive.presentation.test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ap.watchtogive.presentation.theme.BackgroundDark

@Composable
fun TestScreen(
    returnToHome : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .clickable {
                returnToHome()
            }
    ) {

    }
}