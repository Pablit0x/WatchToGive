package com.ap.watchtogive.presentation.home.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ap.watchtogive.presentation.theme.DarkTextColour
import com.ap.watchtogive.presentation.theme.TextColour

@Composable
fun CurrentlyVotedForCard(
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.2f)
        .clickable {
                   //todo Navigate to vote
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Currently Voting For:",
            color = DarkTextColour,
            fontSize = 14.sp
        )

        Text(
            text = "None Selected, tap here to vote now!",
            color = TextColour
        )
    }
}