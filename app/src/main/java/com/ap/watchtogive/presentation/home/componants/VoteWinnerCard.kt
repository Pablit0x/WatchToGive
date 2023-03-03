package com.ap.watchtogive.presentation.home.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ap.watchtogive.presentation.theme.DarkTextColour
import com.ap.watchtogive.presentation.theme.TextColour

@Composable
fun VoteWinnerCard(
) {



    Column(modifier = Modifier
        .fillMaxWidth(0.9f)
        .fillMaxHeight(0.3f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Next Donation Recipient:",
            color = DarkTextColour,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "The British Heart Foundation",
            color = TextColour,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}